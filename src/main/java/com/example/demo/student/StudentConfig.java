package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.security.AllPermission;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){
        return args -> {
            Student Bahaa =new  Student(
                    "Bahaa",
                    "mohamedbahaa@gmail.com",
                    LocalDate.of(2000, Month.NOVEMBER,5)
            );
            Student Alaa =new Student(
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
