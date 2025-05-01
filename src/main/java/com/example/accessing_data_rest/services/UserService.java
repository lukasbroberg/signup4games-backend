package com.example.accessing_data_rest.services;

import com.example.accessing_data_rest.model.User;
import com.example.accessing_data_rest.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers(){
        List<User> users = new ArrayList<>();
        userRepository.findAll().forEach(users::add);
        return users;
    }

    public List<User> searchUsers(String name){
        List<User> user = userRepository.findByName(name);
        return user;
    }

    public User createNewUser(User user){
        userRepository.save(user);
        return user;
    }
}
