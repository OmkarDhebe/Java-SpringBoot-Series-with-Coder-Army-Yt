package com.example.crudDtoDemo.controller;

import com.example.crudDtoDemo.entity.Student;
import com.example.crudDtoDemo.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    StudentService studentService ;
public StudentController(StudentService studentService){
    this.studentService = studentService;
}

    // create
    public ResponseEntity<Student> create (@RequestBody Student student){

  Student studentResp =   studentService.createStudent(student);
return ResponseEntity.ok(studentResp);
    }

}
