package com.example.accessing_data_rest.services;

import com.example.accessing_data_rest.model.Game;
import com.example.accessing_data_rest.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GameServices {

   @Autowired
   private GameRepository gameRepository;

    public List<Game> getAllOpenGames(){
        List<Game> openGames = new ArrayList<>();
        gameRepository.findAll().forEach(openGames::add);
        return openGames;
    }
}
