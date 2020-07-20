package org.example.pattern.observer;

import org.apache.commons.compress.utils.Lists;

import java.util.List;

public class ConcreateSubject implements Subject {
    List<Observer> observers = Lists.newArrayList();

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void deleteObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObserver(String message) {
        observers.forEach(observer -> observer.update(message));
    }
}
