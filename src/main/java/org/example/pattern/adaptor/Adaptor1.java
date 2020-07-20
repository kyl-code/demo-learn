package org.example.pattern.adaptor;

public class Adaptor1 extends Adaptee implements ITarget {
    @Override
    public void function1() {
        super.func1();
    }

    @Override
    public void function2() {
        super.func1();
    }
}
