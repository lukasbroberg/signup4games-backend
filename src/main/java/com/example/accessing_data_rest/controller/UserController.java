package com.example.accessing_data_rest.controller;

import com.example.accessing_data_rest.model.User;
import com.example.accessing_data_rest.services.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("roborally/users")
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/searchUsers")
    public List<User> searchUsers(String name){
        List<User> users = userService.searchUsers(name);
        return users;
    }
}
