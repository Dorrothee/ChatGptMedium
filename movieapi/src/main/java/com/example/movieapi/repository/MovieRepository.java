package com.example.movieapi.repository;

import com.example.movieapi.model.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends MongoRepository<Movie, String> {
    List<Movie> findByTitleContaining(String title);  // Search by title
    List<Movie> findByReleaseDate(String releaseDate);  // Search by release date range
}
