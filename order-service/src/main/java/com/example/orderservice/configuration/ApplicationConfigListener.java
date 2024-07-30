package com.example.orderservice.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;


@Component
public class ApplicationConfigListener implements ApplicationListener<ContextRefreshedEvent> {
    Logger logger = LoggerFactory.getLogger(ApplicationConfigListener.class);

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
    logger.info("Executing configurable method when application is started {}",event.getApplicationContext());
    execute();
    }

    private void execute(){
        logger.info("Executing execute method");
    }
}
