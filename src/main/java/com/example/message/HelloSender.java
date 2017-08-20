package com.example.message;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;


public class HelloSender {


    protected static Logger logger = LoggerFactory.getLogger(HelloSender.class);

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public String send(String name) throws InterruptedException {
        String context = "hello " + name + " --" + new Date();
        String sendStr;
        for (int i = 1; i <= 6; i++) {
            sendStr = "第[" + i + "]个 hello " + name + " --" + new Date();
            logger.debug("HelloSender: " + sendStr);
            this.rabbitTemplate.convertAndSend("hello", sendStr);

            Thread.sleep(1000);
        }
        return context;
    }


}
