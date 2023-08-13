package com.example.demo.teacher;

import com.example.demo.student.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class TeacherConfig {
    @Bean
    CommandLineRunner commandLineRunner (TeacherRepository repository){
        return args-> {
            Teacher Bahaa =new  Teacher(
                    "Bahaa",
                    "mohamedbahaa@gmail.com",
                    LocalDate.of(2000, Month.NOVEMBER,5)
            );
            Teacher Alaa =new Teacher(
                    "Alaa",
                    "mohamedalaa@gmail.com",
                    LocalDate.of(2000, Month.NOVEMBER,5)
            );
            repository.saveAll(
                    List.of(Bahaa,Alaa)
            );

        };
    }
}
