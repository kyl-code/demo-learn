package org.example;

import org.mybatis.spring.boot.autoconfigure.MybatisAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.util.unit.DataSize;
import org.springframework.web.client.RestTemplate;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.servlet.MultipartConfigElement;

/**
 * Hello world!
 */

@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class,
       DataSourceTransactionManagerAutoConfiguration.class,
       MybatisAutoConfiguration.class})
//@EnableJpaRepositories
@EnableSwagger2
public class App{
    public static void main(String[] args) {
        String env = getEnv();
        if(null != env){
            System.setProperty("spring.profiles.active", env);
        }
        SpringApplication.run(App.class, args);
    }

    private static String getEnv(){
        String appEnv = "Foundation.server();";
        switch (appEnv){
            case "dev":
                return "dev";
            case "fat":
                return "uat";
            case "prd":
                return "prd";
            default:
                return null;
        }
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

}

