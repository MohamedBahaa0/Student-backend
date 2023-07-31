package com.example.demo.student;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepository studentRepository;
    @Autowired
    public  StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }
    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public void addNewStudent(Student student){
        Optional <Student> studentByEmail  = studentRepository.findStudentByEmail(student.getEmail());
        if(studentByEmail.isPresent()){
            throw new IllegalStateException("Email taken");

        }
        studentRepository.save(student);
    }

    public void deleteStudent(long id) {
        boolean exists = studentRepository.existsById(id);
        if(!exists){
            throw new IllegalStateException("There is no student with ID" + id );

        }
        studentRepository.deleteById(id);
    }

    @Transactional
    public void updateStudent(long id, String name, String email) {
        boolean exists = studentRepository.existsById(id);
        Student studentById  = studentRepository.findById(id)
                .orElseThrow(()-> new IllegalStateException("There is no student with ID" + id ));
        if( name== null && Objects.equals(studentById.getName(),name)){
            throw new IllegalStateException("Same Name");
        }
        studentById.setName(name);

        if( email!= null && Objects.equals(studentById.getEmail(),email)){
            throw new IllegalStateException("Same Email");
        }
        studentById.setEmail(email);


    }
}
