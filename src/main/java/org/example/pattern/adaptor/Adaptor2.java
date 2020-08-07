package org.example.pattern.adaptor;

import org.apache.commons.compress.utils.Lists;

import java.util.List;

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

    public static void main(String[] args) {
        List<String> list = Lists.newArrayList();
        changeStr(list);
        System.err.println(list);
    }

    private static void changeStr(List<String> str) {
        str.add("Abc");
    }
}
