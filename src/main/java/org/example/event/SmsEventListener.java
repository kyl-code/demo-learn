package org.example.event;

import org.springframework.stereotype.Component;

@Component
public class SmsEventListener implements EventListener {
    @Override
    public void onEvent() {
        System.err.println("sms!!");
    }

    @Override
    public void onEvent(String param) {
        System.err.println("sms:" + param);
    }
}
