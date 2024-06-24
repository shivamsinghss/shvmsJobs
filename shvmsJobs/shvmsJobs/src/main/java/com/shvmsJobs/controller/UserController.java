package com.shvmsJobs.controller;

import com.shvmsJobs.model.AdditionalInformation;
import com.shvmsJobs.model.User;
import com.shvmsJobs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody User user) {
        String response = userService.registerUser(user);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestParam String username, @RequestParam String password) {
        String response = userService.loginUser(username, password);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/details")
    public User getUserDetails(@RequestBody AdditionalInformation additionalInformation) {
        User user = userService.getUserDetails(additionalInformation.getUsername());
        if (user == null) {
            throw new RuntimeException("No such user found");
        }
        return userService.saveAdditionalInformation(additionalInformation);
    }

}

