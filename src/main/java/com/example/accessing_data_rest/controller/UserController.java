package com.example.accessing_data_rest.controller;

import com.example.accessing_data_rest.model.User;
import com.example.accessing_data_rest.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("roborally/users")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * To retrieve all users from the server.
     * @return a list of users
     */
    @GetMapping(value = "", produces = "application/json")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    /**
     * Searches for a specifik user, by a given name parameter from frontend.
     * @param name is the query parameter to get the data from
     * @return returns a list of all users with the given name. (this should only contain one or none users)
     */
    @GetMapping(value = "/searchUsers", produces = "application/json")
    public List<User> searchUsers(@RequestParam("name") String name){
        List<User> users = userService.searchUsers(name);
        return users;
    }

    /**
     * Inserts a new user on the server, using a POST request
     * @param user is the new user object
     * @return returns the newly created user
     */
    @PostMapping(value = "", consumes = "application/json", produces = "application/json")
    public User createNewUser(@RequestBody User user){
        User newUser = userService.createNewUser(user);
        return newUser;
    }
}
