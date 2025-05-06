package com.example.accessing_data_rest.services;

import com.example.accessing_data_rest.model.Game;
import com.example.accessing_data_rest.model.GameState;
import com.example.accessing_data_rest.model.Player;
import com.example.accessing_data_rest.model.User;
import com.example.accessing_data_rest.repositories.GameRepository;
import com.example.accessing_data_rest.repositories.PlayerRepository;
import com.example.accessing_data_rest.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GameServices {

   @Autowired
   private GameRepository gameRepository;

   @Autowired
   private PlayerRepository playerRepository;

    public List<Game> getAllOpenGames(){
        List<Game> openGames = new ArrayList<>();
        gameRepository.findByState(GameState.SIGNUP).forEach(openGames::add);

        return openGames;
    }

    @Transactional
    public Game createNewGame(Game newGame){
        gameRepository.save(newGame);

        User owner = newGame.getOwner();

        //User owner = newGame.getOwner();
        //Create owner as player of the game
        if(owner!=null){
            Player player = new Player();
            player.setUser(owner);
            player.setGame(newGame);
            player.setName(owner.getName());
            playerRepository.save(player);
        }
        return newGame;
    }

    @Transactional
    public void  deleteGame(long gameUID){
        gameRepository.deleteById(gameUID);
    }

    public void startGame(long gameUID){
        Game game = gameRepository.findByUid(gameUID);
        game.setState(GameState.ACTIVE);
        gameRepository.save(game);
    }


}
