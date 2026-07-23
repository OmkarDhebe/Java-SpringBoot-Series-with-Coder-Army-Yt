package in.example.aopDemo.aspect;

import in.example.aopDemo.annotation.TrackExecutionTime;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class SimpleAspect {

//    @Before("execution (String " +
//            "in.example.aopDemo.service.StudentService.getStudent(String))")
//    @Before("@annotaion()")
//    public void logBeforeMethod(){
//        System.out.println("Method Intercepted");
//    }

//    @Around("@annotation(in.example.aopDemo.annotation.TrackExecutionTime)")
@Around("@annotation(trackExecutionTime)")
    public void measureExecutionTime(ProceedingJoinPoint joinPoint, TrackExecutionTime trackExecutionTime) throws Throwable {
        long startTime = System.currentTimeMillis();

        try {
            joinPoint.proceed();
        }
        finally {
            long endTime = System.currentTimeMillis();
            long duration = endTime - startTime;

            String operation = trackExecutionTime.operation();
            if (operation.isBlank()){
                operation = joinPoint.getSignature().getName();
            }

            long warningThreshold = trackExecutionTime.warnAfter();
            if (duration >= warningThreshold){
                System.out.println("Slow operation alert \n " +
                        "Time taken by " +operation +" : "+ duration);
            }
            else{

            String methodName = joinPoint.getSignature().getName();
//            System.out.println("Time taken " + duration + " milliseconds for method " + methodName);


                System.out.println("Time taken by " + operation + " : " + duration);
            }
        }
    }
}
