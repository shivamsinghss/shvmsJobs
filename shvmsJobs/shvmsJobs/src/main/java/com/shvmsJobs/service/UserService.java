package com.shvmsJobs.service;


import com.shvmsJobs.model.User;

public interface UserService {
    String registerUser(User user);
    String loginUser(String username, String password);
    User getUserDetails(String username);
}
