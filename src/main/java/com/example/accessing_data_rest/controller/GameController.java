package com.example.accessing_data_rest.controller;

import com.example.accessing_data_rest.model.Game;
import com.example.accessing_data_rest.services.GameServices;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("roborally/games")
public class GameController {

    private GameServices gameService;

    public GameController(GameServices gameService) {
        this.gameService = gameService;
    }

    @GetMapping(value = "/openGames", produces = "application/json")
    public List<Game> getAllOpenGames(){
        List<Game> openGames = gameService.getAllOpenGames();
        return openGames;
    }
}
