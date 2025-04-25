package com.example.accessing_data_rest.controller;

import com.example.accessing_data_rest.services.GameServices;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("roborally/games")
public class GameController {

    private GameServices gameService;

    public GameController(GameServices gameService) {
        this.gameService = gameService;
    }

    //...
}
