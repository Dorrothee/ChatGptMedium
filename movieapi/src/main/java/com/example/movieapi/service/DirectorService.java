package com.example.movieapi.service;

import com.example.movieapi.model.Director;
import com.example.movieapi.repository.DirectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DirectorService {

    @Autowired
    private DirectorRepository directorRepository;

    public List<Director> getAllDirectors() {
        return directorRepository.findAll();
    }

    public Director getDirectorById(String id) {
        return directorRepository.findById(id).orElse(null);
    }

    public Director createDirector(Director director) {
        return directorRepository.save(director);
    }

    public Director updateDirector(String id, Director director) {
        if (directorRepository.existsById(id)) {
            director.setId(id);
            return directorRepository.save(director);
        }
        return null;
    }

    public void deleteDirector(String id) {
        directorRepository.deleteById(id);
    }
}