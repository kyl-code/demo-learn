package org.example.pattern.decorator;

public class Rectangle implements Shape {
    @Override
    public void draw() {
        System.err.println("this is a rectangle!");
    }
}
