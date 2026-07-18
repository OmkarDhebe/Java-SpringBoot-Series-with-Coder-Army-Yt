package com.example.filterDemo.controller;

import com.example.filterDemo.dto.StudentDto;
import com.example.filterDemo.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/student")
public class StudentController {

    StudentService studentService;
    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<String> createStudent (@RequestBody StudentDto student){
    studentService.createStudent(student);
    return ResponseEntity.ok("Done");
    }
}
