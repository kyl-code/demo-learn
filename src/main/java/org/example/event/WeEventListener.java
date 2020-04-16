package org.example.event;

import org.springframework.stereotype.Component;

@Component
public class WeEventListener implements EventListener {
    @Override
    public void onEvent() {
        System.err.println("we!!");
    }

    @Override
    public void onEvent(String param) {
        System.err.println("we:" + param);
    }
}
