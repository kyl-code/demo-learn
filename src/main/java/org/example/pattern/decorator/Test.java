package org.example.pattern.decorator;

public class Test {
    public static void main(String[] args) {
        ShapeDecorator shapeDecorator = new ShapeDecorator(new Circle());
        shapeDecorator.draw();
    }
}
