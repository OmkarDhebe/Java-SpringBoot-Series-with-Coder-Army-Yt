package in.example.aopDemo.aspect;

import in.example.aopDemo.dto.StudentDto;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;


@Component
@Aspect
public class LoggingAspect {
//    @Before("execution(String in.example.aopDemo.service.StudentService.createStudent())")
//    public void logBeforeMethod(JoinPoint joinPoint) {
//        Object[] arr = joinPoint.getArgs();
//        System.out.println("Student is going to be saved");
//
//
////        boolean allowed = false;
////
////        if (!allowed) {
////            throw new RuntimeException("Student is not allowed to be saved");
////        }
//    }

//    @AfterReturning("execution(String in.example.aopDemo.service.StudentService.createStudent())")
//    public void logAfterReturningMethod(JoinPoint joinPoint) {
////        Object[] arr = joinPoint.getArgs();
//
//
//
//        System.out.println("logAfterReturning Method Called");
//
//
////        boolean allowed = false;
////
////        if (!allowed){
////            throw new RuntimeException("Student is not allowed to be saved");
////        }
//    }
//    @Before("execution(String in.example.aopDemo.service.StudentService.createStudent())")
//    public void logBeforeMethod(JoinPoint joinPoint) {
//        Object[] arr = joinPoint.getArgs();
//        System.out.println("Student is going to be saved");
//
//
//        boolean allowed = false;
//
//        if (!allowed){
//            throw new RuntimeException("Student is not allowed to be saved");
//        }
//    }



//@AfterReturning(value = "execution(in.example.aopDemo.dto.StudentDto" +
//        " in.example.aopDemo.service.StudentService.createStudent" +
//        "(in.example.aopDemo.dto.StudentDto))"
//        , returning = "result")
//public void logAfterReturningMethod(StudentDto result) {
//    //    System.out.println("logAfterReturning Method Called");
//
//
//
////    System.out.println("Target method returned : " + result);
//
//    result.setName("Rohit");
//    result.setAge(40);
//
//    System.out.println("Intercepted create student");
//
//}



    @AfterThrowing(value = "execution(* in.example.aopDemo.service.StudentService.createStudent(..))"
                    ,throwing = "exception")
    public void logAfterThrowingMethod(Throwable exception) {
        //    System.out.println("logAfterReturning Method Called");
        System.out.println("Exception type: " + exception.getClass().getName());
        System.out.println("Exception Message: " + exception.getMessage());




    }


}
