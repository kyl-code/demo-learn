package org.example.service;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

/**
 * @Author Adam_Guo
 * @Date  2020/4/6
 * @Version 1.0
 **/
@Service
public class EventServiceImpl {

    @EventListener
    public void testPublish(String msg){
        System.err.println(msg);
    }
}
