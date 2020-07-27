package org.example.spring;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.MutablePropertySources;

import java.util.HashMap;
import java.util.Map;

public class EnvironmentPropertySourceDemo {

    @Value(("${user.name}"))
    private String userName;

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        // 注册bean
        context.register(EnvironmentPropertySourceDemo.class);

        ConfigurableEnvironment environment = context.getEnvironment();
        MutablePropertySources propertySources = environment.getPropertySources();
        Map<String,Object> map = new HashMap<>();
        map.put("user.name","kyl");
        MapPropertySource propertySource = new MapPropertySource("first-property-source", map);
        propertySources.addFirst(propertySource);
        // 启动容器
        context.refresh();
        EnvironmentPropertySourceDemo bean = context.getBean(EnvironmentPropertySourceDemo.class);
        System.err.println(bean.userName);
        // 关闭容器
        context.close();
    }
}
