package org.example.pattern.decorator;

public class Circle implements Shape {
    @Override
    public void draw() {
        System.err.println("this is a circle!");
    }
}
