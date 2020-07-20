package org.example.pattern.proxy;

public class UserServiceImpl implements IUseService {
    @Override
    public void eat() {
        System.err.println("user eat!");
    }
}
