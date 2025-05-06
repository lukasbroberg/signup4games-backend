package com.example.accessing_data_rest.repositories;

import java.util.List;
import java.util.Optional;

import com.example.accessing_data_rest.model.Game;
import com.example.accessing_data_rest.model.GameState;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "game", path = "game")
public interface GameRepository extends PagingAndSortingRepository<Game, Long>, CrudRepository<Game,Long> {

    Game findByUid(@Param("uid") long uid);

    List<Game> findByName(@Param("name") String name);

    List<Game> findByState(GameState state);

}
