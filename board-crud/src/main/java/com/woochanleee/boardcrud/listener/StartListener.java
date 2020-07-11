package com.woochanleee.boardcrud.listener;

import org.springframework.boot.context.event.ApplicationStartingEvent;
import org.springframework.context.ApplicationListener;

public class StartListener implements ApplicationListener<ApplicationStartingEvent> {

    @Override
    public void onApplicationEvent(ApplicationStartingEvent event) {
        System.out.println("=====================");
        System.out.println("Applcation is starting");
        System.out.println("=====================");
    }
}
