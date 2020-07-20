package org.example.pattern.observer;

public class ConcreateObserverTwo implements Observer {
    @Override
    public void update(String message) {
        System.err.println("observer two:" + message);
    }
}
