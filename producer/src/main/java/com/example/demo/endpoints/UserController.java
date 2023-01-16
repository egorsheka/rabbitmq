
package com.example.demo.endpoints;

import com.example.demo.entity.User;
import com.example.demo.producer.UserProducer;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController
{
    private final UserProducer userProducer;

    public UserController(UserProducer userProducer)
    {
        this.userProducer = userProducer;
    }

    @PostMapping("/user")
    public void sendUser(@RequestBody User user){
        userProducer.sendUser(user);
    }

}
