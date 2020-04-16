package org.example.event;

import org.springframework.stereotype.Component;

@Component
public class AppEventListener implements EventListener {
    @Override
    public void onEvent(String param) {
        System.err.println("app:" + param);
        throw new RuntimeException("EXCEPTION!!!");
    }

    @Override
    public void onEvent() {
        System.err.println("app!");
    }
}
