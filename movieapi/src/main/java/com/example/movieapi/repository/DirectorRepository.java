package com.example.movieapi.repository;

import com.example.movieapi.model.Director;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DirectorRepository extends MongoRepository<Director, String> {
    // Custom queries can be added here
}

