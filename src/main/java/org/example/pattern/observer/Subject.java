package org.example.pattern.observer;

public interface Subject {
    void registerObserver(Observer observer);
    void deleteObserver(Observer observer);
    void notifyObserver(String message);
}
