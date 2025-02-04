package com.example.movieapi.controller;

import com.example.movieapi.model.Director;
import com.example.movieapi.service.DirectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/directors")
public class DirectorController {

    @Autowired
    private DirectorService directorService;

    @GetMapping
    public List<Director> getAllDirectors() {
        return directorService.getAllDirectors();
    }

    @GetMapping("/{id}")
    public Director getDirectorById(@PathVariable String id) {
        return directorService.getDirectorById(id);
    }

    @PostMapping
    public Director createDirector(@RequestBody Director director) {
        return directorService.createDirector(director);
    }

    @PutMapping("/{id}")
    public Director updateDirector(@PathVariable String id, @RequestBody Director director) {
        return directorService.updateDirector(id, director);
    }

    @DeleteMapping("/{id}")
    public void deleteDirector(@PathVariable String id) {
        directorService.deleteDirector(id);
    }
}