
package com.example.demo.producer;

import com.example.demo.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserProducer
{
    private final Logger logger = LoggerFactory.getLogger(UserProducer.class);

    private final RabbitTemplate rabbitTemplate;

    public UserProducer(RabbitTemplate rabbitTemplate)
    {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendUser(User user){
        logger.info("ger {} from", user);
        rabbitTemplate.convertAndSend("mainExchange", "userKey", user);
    }


}
