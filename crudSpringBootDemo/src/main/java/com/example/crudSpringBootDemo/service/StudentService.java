package com.example.crudSpringBootDemo.service;

import com.example.crudSpringBootDemo.entity.Student;
import com.example.crudSpringBootDemo.repository.StudentRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    // 1. End point listen (/api/student POST)

    // 2. Business logic

    // 3. Interect with DB to store

    // 4. response back to client (Postman)

    private StudentRepository studentRepository;
    private StudentService(StudentRepository  studentRepository) {
        this.studentRepository = studentRepository;
    }


    public Student createStudent(Student studentReq) {
 // business logic
// store to db
        System.out.println("Inside StudentService");


        Student studentResponse =  studentRepository.saveStudent(studentReq);
        System.out.println("Exit StudentService");
    return studentResponse;
    }



}
