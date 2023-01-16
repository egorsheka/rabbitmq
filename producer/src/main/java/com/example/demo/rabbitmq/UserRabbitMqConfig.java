
package com.example.demo.rabbitmq;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
public class UserRabbitMqConfig
{

    @Bean
    DirectExchange directExchange(){
        return new DirectExchange("mainExchange");
    }

    @Bean
    DirectExchange failExchange(){
        return new DirectExchange("failExchange");
    }

    @Bean
    Queue userQueue(){
        Map<String, Object> args = Map.of("x-dead-letter-exchange", "failExchange");
        return new Queue("userQueue", true, false, false, args);
    }

    @Bean
    Queue userDeadLetterQueue(){
        return new Queue("userDLQ");
    }

    @Bean
    Binding userBinding(Queue userQueue, DirectExchange directExchange){
        return BindingBuilder.bind(userQueue).to(directExchange).with("userKey");
    }

    @Bean
    Binding userDLQBinding(Queue userDeadLetterQueue, DirectExchange failExchange){
        return BindingBuilder.bind(userDeadLetterQueue).to(failExchange).with("userKey");
    }



}
