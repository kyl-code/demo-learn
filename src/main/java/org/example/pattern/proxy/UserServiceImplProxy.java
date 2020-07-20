package org.example.pattern.proxy;

public class UserServiceImplProxy implements  IUseService {

    private UserServiceImpl userService;

    public UserServiceImplProxy(UserServiceImpl userService){
        this.userService = userService;
    }

    @Override
    public void eat() {
        userService.eat();
        System.err.println("user eat and see!");
    }
}
