package com.example.filterDemo.configuration;

import com.example.filterDemo.filters.DummyFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean<DummyFilter> getDummyFilterBean(){
        FilterRegistrationBean<DummyFilter> filterRegistrationBean = new FilterRegistrationBean<>();
        filterRegistrationBean.setFilter(new DummyFilter());
//        filterRegistrationBean.setOrder();
    filterRegistrationBean.addUrlPatterns("/api/*");
//    filterRegistrationBean.setName("DummyFilter");
        return filterRegistrationBean;

    }
}
