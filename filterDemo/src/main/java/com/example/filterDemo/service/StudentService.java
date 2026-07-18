package com.example.filterDemo.service;

import com.example.filterDemo.dto.StudentDto;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    public void createStudent(StudentDto student) {
        System.out.println("Student Created");
        System.out.println(student.getName());
        System.out.println(student.getEmail());

//        try{
//            Thread.sleep( 2000);
//        }
//        catch (Exception e){}

    }

}
