package com.example.crudSpringBootDemo.controller;

import com.example.crudSpringBootDemo.entity.Student;
import com.example.crudSpringBootDemo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
//        System.out.println("Inside StudentController");


        Student createdStudent = studentService.createStudent(student);
//        System.out.println("Exit StudentController");
//    return "Student created";
//        return createdStudent;

//    return  ResponseEntity.ok(createdStudent);
        return  ResponseEntity.status(HttpStatus.CREATED).body(createdStudent);
    }

// read one student
    @GetMapping("/get/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable Long id ){
Student studentResp = studentService.getStudent(id);

//return ResponseEntity
//        .status(HttpStatus.OK)
//        .body(studentResp);

        if (studentResp == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    return ResponseEntity.ok(studentResp);

    }


     // get all
     @GetMapping("/getAll")
    public ResponseEntity<List<Student>> getAllStudents(){
        List<Student> studentList =studentService.getAllStudent();
        if (studentList.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(studentList);
    }

    //update


    @PutMapping("/update/{id}")
    public ResponseEntity<Student> updateStudents(@PathVariable Long id
            ,@RequestBody Student studentReq){
       Student studentResp = studentService.updateStudent(id, studentReq);
        if (studentResp == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(studentResp);

     }

// delete mapping

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long id){
       Boolean isDeleted = studentService.deleteStudent(id);

       if ( !isDeleted){
           return ResponseEntity.notFound().build();
       }
       return ResponseEntity.ok("Record Deleted");
    }


    @PatchMapping("/delete-soft/{id}")
    public ResponseEntity<String> deleteStudentSoftly(@PathVariable Long id){
    Boolean isDeleted = studentService.deleteStudentSoftly(id);
    if ( !isDeleted){
        return ResponseEntity.notFound().build();
    }
return ResponseEntity.ok("Record Deleted");
    }



}
