package com.example.movieapi.controller;

import com.example.movieapi.model.Actor;
import com.example.movieapi.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/actors")
public class ActorController {

    @Autowired
    private ActorService actorService;

    @GetMapping
    public List<Actor> getAllActors() {
        return actorService.getAllActors();
    }

    @GetMapping("/{id}")
    public Actor getActorById(@PathVariable String id) {
        return actorService.getActorById(id);
    }

    @PostMapping
    public Actor createActor(@RequestBody Actor actor) {
        return actorService.createActor(actor);
    }

    @PutMapping("/{id}")
    public Actor updateActor(@PathVariable String id, @RequestBody Actor actor) {
        return actorService.updateActor(id, actor);
    }

    @DeleteMapping("/{id}")
    public void deleteActor(@PathVariable String id) {
        actorService.deleteActor(id);
    }
}