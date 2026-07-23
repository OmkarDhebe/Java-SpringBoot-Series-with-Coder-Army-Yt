package in.example.aopDemo.controller;

import in.example.aopDemo.dto.StudentDto;
import in.example.aopDemo.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    @PostMapping
    public ResponseEntity<StudentDto> createStudent(@RequestBody StudentDto student ){
        StudentDto s= studentService.createStudent(student);
//        System.out.println(s);
    return ResponseEntity.ok(s);
    }

@GetMapping
    public ResponseEntity<String> getStudents(){
        String s = "All Student Data";
        return ResponseEntity.ok(studentService.getStudent(s));


}
}
