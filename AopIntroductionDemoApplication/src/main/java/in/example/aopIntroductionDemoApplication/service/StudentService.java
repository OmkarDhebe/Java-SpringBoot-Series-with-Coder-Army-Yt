package in.example.aopIntroductionDemoApplication.service;

import in.example.aopIntroductionDemoApplication.dto.StudentDto;

public interface StudentService {

void createStudent(StudentDto studentDto);



}




















//package com.example.AopIntroductionDemoApplication.service;
//
//import com.example.AopIntroductionDemoApplication.dto.StudentDto;
//import com.example.AopIntroductionDemoApplication.repository.StudentRepository;
//import org.springframework.stereotype.Service;
//
//@Service
//public class StudentService {
//    StudentRepository studentRepository;
//    public StudentService (StudentRepository studentRepository) {
//        this.studentRepository = studentRepository;
//    }
//
//    public void createStudent(StudentDto student){
//        studentRepository.save(student);
//        System.out.println("Student is saved successfully");
//    }
//
//
//}
