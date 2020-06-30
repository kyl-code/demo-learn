package org.example.spring;

import org.springframework.beans.factory.DisposableBean;

import javax.annotation.PreDestroy;
import java.util.HashMap;
import java.util.Map;

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

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        // 执行代码
        long endTime = System.nanoTime();
        System.out.println(endTime - startTime);

        System.out.println("===================");
        long startTime2 = System.currentTimeMillis();
       // 执行代码
        long endTime2 = System.currentTimeMillis();
        System.out.println(endTime2 - startTime2);

        Map<Integer,String> map = new HashMap();
        map.put(1,"zhangsan");
        map.put(2,"lisi");
        map.put(3,"wangwu");

        map.entrySet().stream();




    }
}
