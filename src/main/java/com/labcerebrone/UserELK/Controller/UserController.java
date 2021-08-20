package com.labcerebrone.UserELK.Controller;


import com.labcerebrone.UserELK.Entity.User;
import com.labcerebrone.UserELK.Service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userservice;

    @PostMapping("/")
    public User saveUser(@RequestBody User user){
        logger.info("Saving User");
        return userservice.saveUser(user);
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable("id") int userId){
        logger.info("Getting User");
        return userservice.findByUserId(userId);
    }
    @GetMapping("/all")
    public List<User> getAllUser(){
        logger.info("Getting All Users");
        return userservice.getAll();
    }
}
