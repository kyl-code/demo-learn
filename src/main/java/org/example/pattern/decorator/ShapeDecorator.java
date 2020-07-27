package org.example.pattern.decorator;

public class ShapeDecorator implements Shape{
    private Shape shape;

    ShapeDecorator(Shape shape){
        this.shape = shape;
    }

    public void draw(){
        shape.draw();
        System.err.println("this is an decorator!");
    }
}
