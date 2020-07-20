package org.example.pattern.adaptor;

public class Adaptor2 implements ITarget {
    private Adaptee adaptee;

    public Adaptor2(Adaptee adaptee){
        this.adaptee = adaptee;
    }

    @Override
    public void function1() {
        adaptee.func1();
    }

    @Override
    public void function2() {
        adaptee.func2();
    }
}
