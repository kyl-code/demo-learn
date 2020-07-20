package org.example.pattern.singleton;

public class TestSingleton {
    public static void main(String[] args) {
        Long id = IdGeneratorStatic.getInstance().getId();
        System.err.println(id);
    }
}
