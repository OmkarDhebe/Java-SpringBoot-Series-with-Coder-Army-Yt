package com.example.filterDemo.filters;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.util.ContentCachingResponseWrapper;

import java.io.IOException;

//@Component
public class ResponseBodyFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;

        ContentCachingResponseWrapper wrapperResponse = new ContentCachingResponseWrapper(httpServletResponse);
        filterChain.doFilter(httpServletRequest, wrapperResponse);
        byte[] originalBodyBytes = wrapperResponse.getContentAsByteArray();

        String originallBody = new String(originalBodyBytes);
        String modifiedBody = """
            {
            "originalResponse" : %s ,
            "appName" : "Student Management App"
            }        
        
                """.formatted(originallBody);

//        wrapperResponse.resetBuffer();
        wrapperResponse.resetBuffer();

        wrapperResponse.getWriter().write(modifiedBody);

        wrapperResponse.copyBodyToResponse();

    }
}
