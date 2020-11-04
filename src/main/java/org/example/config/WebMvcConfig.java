package org.example.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author adam.guo
 * @date:2020/10/9
 * 用于图片上传后的访问映射
 */

//@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Value("${file.path}")
    private String fileRootPath;

    /**
     * 资源映射:把请求的/archive/** 映射到该文件根路径
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/archive/**").addResourceLocations("file:" + fileRootPath);
        registry.addResourceHandler("/file/**").addResourceLocations("classpath:/file/");
    }
}