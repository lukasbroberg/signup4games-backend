package com.example.accessing_data_rest.controller;

import com.example.accessing_data_rest.model.Player;
import com.example.accessing_data_rest.services.PlayerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("roborally/players")
public class PlayerController {

    @Autowired
    private PlayerServices playerServices;

    @PostMapping(value = "/createNew", consumes = "application/json", produces = "application/json")
    public Player createNewPlayer(@RequestBody Player player){
        return playerServices.createNewPlayer(player);
    }

    @DeleteMapping(value = "/delete/{id}")
    public void deletePlayer(@PathVariable("id") long playerUid){
        playerServices.deletePlayer(playerUid);
    }
}
