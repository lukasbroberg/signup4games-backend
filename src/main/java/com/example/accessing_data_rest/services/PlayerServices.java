package com.example.accessing_data_rest.services;

import com.example.accessing_data_rest.exception.UnableToCreatePlayerException;
import com.example.accessing_data_rest.model.Game;
import com.example.accessing_data_rest.model.Player;
import com.example.accessing_data_rest.model.User;
import com.example.accessing_data_rest.repositories.GameRepository;
import com.example.accessing_data_rest.repositories.PlayerRepository;
import com.example.accessing_data_rest.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayerServices {
    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private GameRepository gameRepository;

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public Player createNewPlayer(Player player){
        Game game = player.getGame();
        User user = player.getUser();

        //Player needs to contain a user and game
        if(game==null || user==null){
            throw new UnableToCreatePlayerException("Player does nto refer to a game and user");
        }

        game = gameRepository.findByUid(player.getGame().getUid());
        user = userRepository.findByUid(player.getUser().getUid());

        //Game repository must contain the same user and game
        if(game==null || user==null){
            throw new UnableToCreatePlayerException("Player does nto refer to a game and user");
        }

        //Player must not already be signed up
        for(Player players: game.getPlayers()){
            User playerUser = players.getUser();
            if(playerUser.getUid()==user.getUid()){
                throw new UnableToCreatePlayerException("User is already signed up for this game");
            }
        }

        if(player.getName()==null){
            player.setName(user.getName());
        }

        var result = playerRepository.save(player);
        return result;
    }

    public void deletePlayer(long UID){
        playerRepository.deleteById(UID);
    }
}
