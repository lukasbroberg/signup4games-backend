package com.example.accessing_data_rest.repositories;

import com.example.accessing_data_rest.model.Player;
import com.example.accessing_data_rest.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;


@RepositoryRestResource(collectionResourceRel = "user", path = "user")
public interface UserRepository extends PagingAndSortingRepository<User, Long>, CrudRepository<User,Long> {

    User findByUid(@Param("uid") long uid);

    List<User> findByName(@Param("name") String name);
    
}
