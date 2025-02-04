package com.example.movieapi.service;

import com.example.movieapi.model.Actor;
import com.example.movieapi.repository.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActorService {

    @Autowired
    private ActorRepository actorRepository;

    public List<Actor> getAllActors() {
        return actorRepository.findAll();
    }

    public Actor getActorById(String id) {
        return actorRepository.findById(id).orElse(null);
    }

    public Actor createActor(Actor actor) {
        return actorRepository.save(actor);
    }

    public Actor updateActor(String id, Actor actor) {
        if (actorRepository.existsById(id)) {
            actor.setId(id);
            return actorRepository.save(actor);
        }
        return null;
    }

    public void deleteActor(String id) {
        actorRepository.deleteById(id);
    }
}