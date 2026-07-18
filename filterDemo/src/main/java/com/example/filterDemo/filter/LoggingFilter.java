package com.example.filterDemo.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpServletResponseWrapper;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.UUID;

@Component
@Order(2)
public class LoggingFilter implements Filter {


    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain)
            throws IOException, ServletException {

        long startTime = System.currentTimeMillis();

//        System.out.println("Request entered in LoggingFilter");
//
//        filterChain.doFilter(servletRequest, servletResponse);
//
//        System.out.println("Request exiting in LoggingFilter");
//


    HttpServletRequest  httpRequest = (HttpServletRequest) servletRequest;

    HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;


    String requestId = UUID.randomUUID().toString();
    httpResponse.addHeader("X-Request-Id", requestId);


    // request log

        System.out.println("Incoming request " +httpRequest.getMethod() + " " + httpRequest.getRequestURI() );

        try{
            filterChain.doFilter(servletRequest, servletResponse);
        }

        finally {
            long  duration = System.currentTimeMillis() - startTime;


// response status log
            System.out.println("Response status : " +   httpResponse.getStatus());


            System.out.println("API Response time : " +   duration);

        }



  }
}
