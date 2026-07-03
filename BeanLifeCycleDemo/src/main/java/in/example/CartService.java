package in.example;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

  @Component
public class CartService  implements BeanNameAware, ApplicationContextAware /* DisposableBean
         /* InitializingBean */ {

    Map<Integer,String> mp;
    public CartService(){
         mp = new HashMap<>();
        System.out.println("CartService Constructor called");

        
    }
    public void addToCart(){
        System.out.println("Added to cart");
    }


//    @Override
//    public void afterPropertiesSet() throws Exception {
////        System.out.println("Initialization callback");
//        System.out.println("Bean is ready");
//
//        mp.put(1 ,"Rohit");
//        mp.put(2,"Rahul");
//    }

    public String getValue(int key){
  return mp.get(key);
    }

//    public void start(){
//        System.out.println("Bean is ready");
//
//        mp.put(1 ,"Rohit");
//        mp.put(2,"Rahul");
//    }

    @PostConstruct
    public void start2(){
        System.out.println("Bean is ready");

        mp.put(1 ,"Rohit");
        mp.put(2,"Rahul");
    }

     @Override
     public void setBeanName(String name) {
         System.out.println("Bean name is "+ name);
     }

//     @Override
//     public void destroy() throws Exception {
//        mp.clear();
//         System.out.println("Bean is getting destroyed ");
//     }

     @Override
     public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
         System.out.println("ApplicationContext is"+ applicationContext.getClass());

     }

//         public void stop(){
//       mp.clear();
//             System.out.println("Bean is getting destroyed");
//         }

      @PreDestroy
      public void stop(){
        mp.clear();
          System.out.println("Bean is getting Destroyed");
      }

         }
