package org.example.strategy;

/**
 * @Author Adam_Guo
 * @Date 2020/4/20
 * @Version 1.0
 **/
public class TestStrategy {
    public static void main(String[] args) {
        Context context = new Context(new Student());
        context.eat();
    }
}
