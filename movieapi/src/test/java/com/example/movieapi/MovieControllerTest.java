package com.example.movieapi;

import com.example.movieapi.controller.MovieController;
import com.example.movieapi.model.Movie;
import com.example.movieapi.service.MovieService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Date;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(MovieController.class)
public class MovieControllerTest {

    @Autowired
    private MockMvc mockMvc; // Mock MVC for simulating HTTP requests

    @MockitoBean
    private MovieService movieService; // Mock the service layer

    private Movie movie;

    @BeforeEach
    public void setup() {
        movie = new Movie();
        movie.setId("1");
        movie.setTitle("Inception");
        movie.setReleaseDate(new Date());
        movie.setRuntime(148);
    }

    @Test
    public void testGetAllMovies() throws Exception {
        // Set up mock service response
        when(movieService.getAllMovies()).thenReturn(List.of(movie));

        // Perform the HTTP request and check the result
        mockMvc.perform(get("/api/movies"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].title").value("Inception"));
    }

    @Test
    public void testGetMovieById() throws Exception {
        // Set up mock service response
        when(movieService.getMovieById("1")).thenReturn(movie);

        // Perform the HTTP request and check the result
        mockMvc.perform(get("/api/movies/{id}", "1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("Inception"));
    }

    @Test
    public void testCreateMovie() throws Exception {
        // Set up mock service response
        when(movieService.createMovie(any(Movie.class))).thenReturn(movie);

        // Perform the HTTP request and check the result
        mockMvc.perform(post("/api/movies")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"title\":\"Inception\", \"releaseDate\":\"2023-01-01\", \"runtime\":148}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("Inception"));
    }

    @Test
    public void testUpdateMovie() throws Exception {
        // Set up mock service response
        when(movieService.updateMovie(eq("1"), any(Movie.class))).thenReturn(movie);

        // Perform the HTTP request and check the result
        mockMvc.perform(put("/api/movies/{id}", "1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"title\":\"Inception\", \"releaseDate\":\"2023-01-01\", \"runtime\":148}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("Inception"));
    }

    @Test
    public void testDeleteMovie() throws Exception {
        // Set up mock service response
        doNothing().when(movieService).deleteMovie("1");

        // Perform the HTTP request and check the result
        mockMvc.perform(delete("/api/movies/{id}", "1"))
                .andExpect(status().isOk());
    }
}
