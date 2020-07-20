package org.example.pattern.observer;

public class TestObserver {
    public static void main(String[] args) {
        Subject subject = new ConcreateSubject();
        subject.registerObserver(new ConcreateObserverOne());
        subject.notifyObserver("now notify all the observers!!!");
    }
}
