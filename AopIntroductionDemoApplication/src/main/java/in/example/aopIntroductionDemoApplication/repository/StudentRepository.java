package in.example.aopIntroductionDemoApplication.repository;

import in.example.aopIntroductionDemoApplication.dto.StudentDto;
import org.springframework.stereotype.Repository;

@Repository
public class StudentRepository {

    public void save(StudentDto student){
        System.out.println("Student saved");
    }
}
