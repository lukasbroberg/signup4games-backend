package com.example.accessing_data_rest.services;

import com.example.accessing_data_rest.model.User;
import com.example.accessing_data_rest.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getUsers;

    public List<User> searchUsers(String name){
        List<User> user = userRepository.findByName(name);
        return user;
    }
    //...
}
