package org.example.filter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean MyFilterRegistration() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new ParamFilter());
        registration.addUrlPatterns("/*");
        registration.addInitParameter("paramName", "paramValue");//添加默认参数
        registration.setName("ParamFilter");
        registration.setOrder(1);//先后顺序
        return registration;

    }


}
