package in.example.aopIntroductionDemoApplication.service;

import in.example.aopIntroductionDemoApplication.dto.StudentDto;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
//@Primary
public class LoggingDecorator implements StudentService {
    private StudentServiceImpl studentServiceimpl;

    public LoggingDecorator(StudentServiceImpl studentServiceimpl) {
        this.studentServiceimpl = studentServiceimpl;
    }


    @Override
    public void createStudent(StudentDto student) {
        //  logging realated logic

        LoggingServiceUtil.logStart(
                "StudentServiceImpl", "createStudent");
        studentServiceimpl.createStudent(student);
        LoggingServiceUtil.logEnd(
                "StudentServiceImpl", "createStudent");

    }



}
