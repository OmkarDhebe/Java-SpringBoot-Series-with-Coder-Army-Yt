package com.example.filterDemo.service;

import com.example.filterDemo.dto.StudentDto;
import com.example.filterDemo.dto.StudentResponseDto;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

//    public void createStudent(StudentDto student) {
////        System.out.println("Student Created");
////        System.out.println(student.getName());
////        System.out.println(student.getEmail());
//
////        try{
////            Thread.sleep( 2000);
////        }
////        catch (Exception e){}
//
//
//
//
//    }

    public StudentResponseDto createStudent(StudentDto student) {

        StudentResponseDto studentResponseDto = new StudentResponseDto();
        studentResponseDto.setName(student.getName());
        studentResponseDto.setMessage("Student is saved successfully");

        return studentResponseDto;
    }


}
