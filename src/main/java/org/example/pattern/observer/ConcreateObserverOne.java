package org.example.pattern.observer;

public class ConcreateObserverOne implements Observer {
    @Override
    public void update(String message) {
        System.err.println("observer one :" + message);
    }
}
