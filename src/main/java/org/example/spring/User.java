package org.example.spring;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.config.BeanPostProcessor;

import javax.annotation.PreDestroy;

public class User implements DisposableBean {
    private String name;
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public void destroy() throws Exception {
        System.err.println("disposableBean!");
    }

    @PreDestroy
    public void preDestroy(){
        System.err.println("preDestroy!!");
    }
}
