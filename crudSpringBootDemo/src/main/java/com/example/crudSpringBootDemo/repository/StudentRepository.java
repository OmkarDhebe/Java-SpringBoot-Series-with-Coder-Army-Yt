package com.example.crudSpringBootDemo.repository;

import com.example.crudSpringBootDemo.entity.Student;
import org.springframework.stereotype.Component;

@Component
public class StudentRepository {

    public Student saveStudent(Student studentReq){
        System.out.println("Inside StudentRepository");
        System.out.println("Exit StudentRepository");

        Student s1 = new Student();

        s1.setName("Virat");
        s1.setAge(40);
        s1.setEmail("virat@18.in");
        s1.setRollNo(18);
        s1.setSubject("spring framework");

        return s1;
    }


}
