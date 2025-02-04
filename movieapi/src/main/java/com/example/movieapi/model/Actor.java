package com.example.movieapi.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Setter
@Getter
public class Actor {
    @Id
    private String id;
    private String name;

}
