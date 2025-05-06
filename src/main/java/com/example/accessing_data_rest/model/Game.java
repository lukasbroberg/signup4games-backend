package com.example.accessing_data_rest.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.List;

@Entity
@JsonIdentityInfo(
        scope = Game.class,
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "uid"
)
public class Game {

    @Id
    @Column(name="game_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long uid;

    private String name;

    @ManyToOne
    @NotFound(action = NotFoundAction.IGNORE)
    private User owner;

    @NotFound(action = NotFoundAction.IGNORE)
    private GameState state;

    private int minPlayers;

    private int maxPlayers;

    @OneToMany(mappedBy="game")
    @OnDelete(action = OnDeleteAction.CASCADE)
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
