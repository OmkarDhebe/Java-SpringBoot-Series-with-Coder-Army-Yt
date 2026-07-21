package in.example.aopIntroductionDemoApplication.controller;

import in.example.aopIntroductionDemoApplication.dto.StudentDto;
import in.example.aopIntroductionDemoApplication.service.StudentService;
import in.example.aopIntroductionDemoApplication.service.StudentServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/students")
public class StudentController {
   private StudentService studentService;
    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }
    @PostMapping
    public ResponseEntity<String> createStudent(StudentDto student){

        studentService.createStudent(student);
  return ResponseEntity.ok("Done");

    }


}
