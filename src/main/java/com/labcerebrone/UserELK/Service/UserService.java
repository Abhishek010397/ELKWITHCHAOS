package com.labcerebrone.UserELK.Service;

import com.labcerebrone.UserELK.Entity.User;
import com.labcerebrone.UserELK.Repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserRepository userRepository;

    public User saveUser(User user) {
        try {
            if (user != null) {
                user = userRepository.save(user);
                logger.info("user saved: {}", user);
                return user;
            } else {
                try {
                    throw new Exception();
                } catch (Exception e) {
                    e.printStackTrace();
                    logger.error("user cannot be saved: {}", user);
                }
            }
        }
        catch (Exception e){
            e.printStackTrace();
            logger.error(String.valueOf(e));
        }
        return new User();
    }

    public User findByUserId(int userId) {
        try {
            if (userId != 0) {
                User user = userRepository.findByUserId(userId);
                logger.info("user found: {}", userId);
                return user;
            } else {
                try {
                    throw new Exception();
                } catch (Exception e) {
                    e.printStackTrace();
                    logger.error("user not found: {}", userId);
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            logger.error(String.valueOf(e));
        }
        return new User();
    }

    public List<User> getAll() {
        try{
            List<User> users = userRepository.findAll();
            return users;
        }
        catch (Exception e){
            e.printStackTrace();
            logger.error("Users Not Found");
        }
        return new ArrayList<>();
    }
}
