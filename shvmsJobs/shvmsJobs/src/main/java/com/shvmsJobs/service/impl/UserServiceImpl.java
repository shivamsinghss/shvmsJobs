package com.shvmsJobs.service.impl;

import com.shvmsJobs.model.User;
import com.shvmsJobs.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;


@Service
public class UserServiceImpl implements UserService {
    private final Map<String, User> userMap = new HashMap<>();
    Logger logger= LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public String registerUser(User user) {
        if (userMap.containsKey(user.getUsername())) {
            return "User already exists!";
        }
        userMap.put(user.getUsername(), user);
        return "User registered successfully!";
    }

    @Override
    public String loginUser(String username, String password) {
        User user = userMap.get(username);
        if (user == null) {
            return "User not found!";
        }
        if (!user.getPassword().equals(password)) {
            return "Invalid credentials!";
        }
        return "Login successful!";
    }

    @Override
    public User getUserDetails(String username) {
        logger.info("userMap:::::::{}",userMap);
        return userMap.get(username);
    }
}
