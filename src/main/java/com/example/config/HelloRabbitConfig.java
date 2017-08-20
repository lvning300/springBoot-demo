package com.example.config;


import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HelloRabbitConfig {

    @Bean
    public Queue helloQueue() {
        return new Queue("hello", true);
    }

}
