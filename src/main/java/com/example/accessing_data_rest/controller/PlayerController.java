package com.example.accessing_data_rest.controller;

import com.example.accessing_data_rest.services.PlayerServices;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("roborally/games")
public class PlayerController {
    //@PostMapping(value = "", ...)
    //@GetMapping(value = "")

    private PlayerServices playerServices;

    public PlayerController(PlayerServices playerServices) {
        this.playerServices = playerServices;
    }
}
