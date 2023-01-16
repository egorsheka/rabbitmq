
package com.example.demo.rabbitmq;

import com.example.demo.entity.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class UserListener
{
    private final Logger logger = LoggerFactory.getLogger(UserListener.class);

    @RabbitListener(queues = "userQueue")
    public void getUser(User user) throws Exception
    {
        logger.info("ger {} from", user);
        if (user.getName().equals("egor"))
        throw new Exception();
    }
}
