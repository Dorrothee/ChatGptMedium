package com.example.movieapi.repository;

import com.example.movieapi.model.Actor;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ActorRepository extends MongoRepository<Actor, String> {
    // You can add custom queries if needed
}

