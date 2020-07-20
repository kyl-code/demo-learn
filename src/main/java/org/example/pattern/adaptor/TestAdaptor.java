package org.example.pattern.adaptor;

public class TestAdaptor {
    public static void main(String[] args) {
        ITarget iTarget = new Adaptor1();
        iTarget.function1();

        ITarget iTarget1 = new Adaptor2(new Adaptee());
        iTarget1.function1();
    }
}
