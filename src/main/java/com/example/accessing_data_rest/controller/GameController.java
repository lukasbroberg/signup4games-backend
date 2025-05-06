package com.example.accessing_data_rest.controller;

import com.example.accessing_data_rest.model.Game;
import com.example.accessing_data_rest.services.GameServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("roborally/games")
public class GameController {

    @Autowired
    private GameServices gameService;

    @GetMapping(value = "/openGames", produces = "application/json")
    public List<Game> getAllOpenGames(){
        return gameService.getAllOpenGames();
    }

    @PostMapping(value = "/createNewGame", consumes = "application/json", produces = "application/json")
    public Game createNewGame(@RequestBody Game newGame){
        return gameService.createNewGame(newGame);
    }

    @DeleteMapping(value = "{id}")
    public void deleteGame(@PathVariable("id") long gameUID){
        gameService.deleteGame(gameUID);
    }

    @PatchMapping(value = "/start/{id}")
    public void startGame(@PathVariable("id") long gameUID){
        gameService.startGame(gameUID);
    }
}
