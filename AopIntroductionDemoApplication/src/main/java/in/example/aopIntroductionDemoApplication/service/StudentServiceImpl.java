package in.example.aopIntroductionDemoApplication.service;

import in.example.aopIntroductionDemoApplication.dto.StudentDto;
import in.example.aopIntroductionDemoApplication.repository.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {
    StudentRepository studentRepository;
 public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public void createStudent(StudentDto student){
     try{
         Thread.sleep(2000);

     }
     catch(Exception e){ }
    studentRepository.save(student);
        System.out.println("Student is saved successfully");
    }


}
