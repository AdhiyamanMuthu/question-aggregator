package com.code.coder.config;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class InitializeData {

    @EventListener(ApplicationReadyEvent.class)
    public void loadData() {
    	
    }
    
}