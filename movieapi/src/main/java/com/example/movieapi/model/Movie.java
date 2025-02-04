package com.example.movieapi.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Document(collection = "movies")
public class Movie {

    @Id
    private String id;
    private String title;
    private Date releaseDate;
    private int runtime; // in minutes
    @DBRef
    private List<Actor> actors;
    @DBRef
    private List<Director> directors;

}
