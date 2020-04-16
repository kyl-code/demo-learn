package org.example.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class HandleEvent {
    @Autowired
    private List<EventListener> listeners;

    public void handleSomething(String param){
        for (EventListener eventListener : listeners){
            eventListener.onEvent(param);
        }
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(HandleEvent.class);
        applicationContext.register(AppEventListener.class);
        applicationContext.register(SmsEventListener.class);
        applicationContext.register(WeEventListener.class);
        applicationContext.refresh();
        HandleEvent handleEvent = applicationContext.getBean(HandleEvent.class);
        handleEvent.handleSomething("12");
    }
}
