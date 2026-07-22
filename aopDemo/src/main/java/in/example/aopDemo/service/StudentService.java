package in.example.aopDemo.service;

import in.example.aopDemo.dto.StudentDto;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    public StudentDto createStudent(StudentDto student){
        System.out.println("Student is going to be saved");
//try {
//    throw new RuntimeException("Some Error occured");
//}
//catch(RuntimeException e){ }

//        throw new RuntimeException("Some Error occured");
//        return "Student Saved";
//        return "Student Saved";

        throw new RuntimeException("Some error happend");

//        return student;
    }



}
