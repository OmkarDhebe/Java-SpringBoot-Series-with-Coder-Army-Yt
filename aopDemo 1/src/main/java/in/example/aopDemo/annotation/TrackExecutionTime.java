package in.example.aopDemo.annotation;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface TrackExecutionTime {
    long warnAfter() default 2000;
    String operation()  default "";

}
