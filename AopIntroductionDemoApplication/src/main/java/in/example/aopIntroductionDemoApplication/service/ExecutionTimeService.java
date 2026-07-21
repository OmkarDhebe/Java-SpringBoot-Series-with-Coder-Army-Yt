package in.example.aopIntroductionDemoApplication.service;

import in.example.aopIntroductionDemoApplication.dto.StudentDto;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class ExecutionTimeService  implements  StudentService{

    private LoggingDecorator loggingDecorator;

    public ExecutionTimeService(LoggingDecorator loggingDecorator) {
        this.loggingDecorator = loggingDecorator;
    }

    @Override
    public void createStudent(StudentDto student) {
long start = System.currentTimeMillis();
loggingDecorator.createStudent(student);

   long end = System.currentTimeMillis();
        System.out.println("Duration of  Execution Time is " + (end-start));
    }
}
