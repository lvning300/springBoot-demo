package com.example.message;


import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;

@Component
public class HelloReceiver {
    private static int count = 0;

    @RabbitHandler
    @RabbitListener(queues = "hello")
    public void process(Message message) throws Exception {
        count++;
        String content = getString(message);
        System.out.printf("HelloReceiver : %s%n", content + " count: " + count);
        try {
            Thread.sleep(8000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        testQueueBrack();



    }

    private String getString(Message message) {
        try {
            return new String(message.getBody(), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return "";
    }

    private void testQueueBrack() throws Exception {
        throw new Exception("asdfasdfasdfasdf");
    }

}