package org.example.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyWebMvcConfigurerAdapter implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new MessageInterceptor()).
                addPathPatterns("/**").
                excludePathPatterns("/emp/toLogin", "/emp/login", "/js/**", "/css/**", "/images/**");

    }
}
