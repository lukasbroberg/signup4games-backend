package com.example.accessing_data_rest.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Game {

    @Id
    @Column(name="game_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long uid;

    private String name;

    private User owner;

    private GameState state;

    private int minPlayers;

    private int maxPlayers;

    @OneToMany(mappedBy="game")
    private List<Player> players;

    public User getOwner(){
        return this.owner;
    }
    public void setOwner(User owner){
        this.owner=owner;
    }

    public GameState getState(){
        return state;
    }

    public void setState(GameState state){
        this.state=state;
    }


    public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public int getMinPlayers() {
        return minPlayers;
    }

    public void setMinPlayers(int minPlayers) {
        this.minPlayers = minPlayers;
    }

    public int getMaxPlayers() {
        return maxPlayers;
    }

    public void setMaxPlayers(int maxPlayers) {
        this.maxPlayers = maxPlayers;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

}
