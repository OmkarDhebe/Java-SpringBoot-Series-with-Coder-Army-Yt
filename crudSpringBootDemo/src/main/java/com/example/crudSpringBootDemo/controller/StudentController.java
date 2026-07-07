package com.example.crudSpringBootDemo.controller;

import com.example.crudSpringBootDemo.entity.Student;
import com.example.crudSpringBootDemo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/student")
public class StudentController {

//    @Autowired
//    private StudentService studentService;

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // create student
    @PostMapping("/create")
    public ResponseEntity<Student> createStudent(@RequestBody  Student student){
//        System.out.println(student.getName());
//        System.out.println(student.getEmail());
        System.out.println("Inside StudentController");


        Student createdStudent = studentService.createStudent(student);
        System.out.println("Exit StudentController");
//    return "Student created";
//        return createdStudent;

//    return  ResponseEntity.ok(createdStudent);
        return  ResponseEntity.status(HttpStatus.CREATED).body(createdStudent);
    }


}
