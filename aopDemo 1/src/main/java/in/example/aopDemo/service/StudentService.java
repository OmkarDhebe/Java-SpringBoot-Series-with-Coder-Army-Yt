package in.example.aopDemo.service;

import in.example.aopDemo.annotation.TrackExecutionTime;
import in.example.aopDemo.dto.StudentDto;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Service
public class StudentService {
@TrackExecutionTime(warnAfter = 2000 ,operation = "Creating new student")
    public StudentDto createStudent(StudentDto student){
        System.out.println("Student is going to be saved");


       return student;
    }

    @TrackExecutionTime(warnAfter = 1500,operation = "Get Student data ")
    public String getStudent(String s){
try {
    Thread.sleep(2000);
}
catch (Exception e) {}
System.out.println(s);
        return s;
    }

public int dummyMethod(){
        return 0;
}

}
