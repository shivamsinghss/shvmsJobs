package com.shvmsJobs.service.impl;

import com.shvmsJobs.model.AdditionalInformation;
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
        logger.info("New User added with details:::::::{}",user);
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
        logger.info("Successfully Logged in as:::::::{} with details::::{}",username,user);
        return "Login successful!";
    }

    @Override
    public User getUserDetails(String username) {
        logger.info("userMap:::::::{}",userMap);
        return userMap.get(username);
    }

    @Override
    public User saveAdditionalInformation(AdditionalInformation additionalInformation) {
        User user=userMap.get(additionalInformation.getUsername());
        user.setAdditionalInformation(additionalInformation);
        userMap.put(additionalInformation.getUsername(), user);
        logger.info("updated userMap:::::::{}",userMap);
        return user;
    }


}
