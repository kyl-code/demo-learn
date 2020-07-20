package org.example.pattern.proxy;

public class TestProxy {
    public static void main(String[] args) {
        UserServiceImplProxy userServiceImplProxy = new UserServiceImplProxy(new UserServiceImpl());
        userServiceImplProxy.eat();
    }
}
