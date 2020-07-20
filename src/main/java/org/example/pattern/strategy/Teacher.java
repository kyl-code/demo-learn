package org.example.pattern.strategy;

/**
 * @Author Adam_Guo
 * @Date 2020/4/20
 * @Version 1.0
 **/
public class Teacher implements Person {
    @Override
    public void eat() {
        System.out.println("teacher eat!!!");
    }
}
