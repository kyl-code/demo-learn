package org.example;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.util.unit.DataSize;
import org.springframework.web.client.RestTemplate;

import javax.servlet.MultipartConfigElement;

/**
 * Hello world!
 */

@SpringBootApplication
//@EnableJpaRepositories
@MapperScan(basePackages = "org.example.dao")
public class App implements ApplicationRunner {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.getEnvironment().setActiveProfiles();
        SpringApplication.run(App.class, args);
    }


    @Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        // 设置单个附件大小上限值(默认为1M)
        // 选择字符串作为参数的话，单位可以用MB、KB;
        factory.setMaxFileSize(DataSize.ofMegabytes(50L));
        // 设置所有附件的总大小上限值
        factory.setMaxRequestSize(DataSize.ofMegabytes(250L));
        return factory.createMultipartConfig();
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder){
        return builder.build();
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

    }
}

