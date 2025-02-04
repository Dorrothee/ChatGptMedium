package com.example.movieapi;

import com.example.movieapi.model.Movie;
import com.example.movieapi.repository.MovieRepository;
import com.example.movieapi.service.MovieService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class MovieServiceTest {

    @Mock
    private MovieRepository movieRepository; // Mock the MovieRepository

    private MovieService movieService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);  // Initialize the mocks
        movieService = new MovieService(movieRepository);
    }

    @Test
    public void testGetAllMovies() {
        Movie movie = new Movie();
        movie.setTitle("Inception");
        movie.setReleaseDate(new Date());
        movie.setRuntime(148);
        List<Movie> movieList = Arrays.asList(movie);

        when(movieRepository.findAll()).thenReturn(movieList);

        List<Movie> result = movieService.getAllMovies();

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("Inception", result.get(0).getTitle());
        verify(movieRepository, times(1)).findAll();  //Ensure repository method was called
    }

    @Test
    public void testGetMovieById() {
        Movie movie = new Movie();
        movie.setTitle("Inception");
        movie.setReleaseDate(new Date());
        movie.setRuntime(148);

        when(movieRepository.findById("movieId")).thenReturn(Optional.of(movie));

        Movie result = movieService.getMovieById("movieId");

        assertNotNull(result);
        assertEquals("Inception", result.getTitle());
        verify(movieRepository, times(1)).findById("movieId");
    }

    @Test
    public void testCreateMovie() {
        Movie movie = new Movie();
        movie.setTitle("Inception");
        movie.setReleaseDate(new Date());
        movie.setRuntime(148);

        when(movieRepository.save(any(Movie.class))).thenReturn(movie);

        Movie result = movieService.createMovie(movie);

        assertNotNull(result);
        assertEquals("Inception", result.getTitle());
        verify(movieRepository, times(1)).save(any(Movie.class));
    }

    @Test
    public void testUpdateMovie() {
        Movie movie = new Movie();
        movie.setTitle("Inception");
        movie.setReleaseDate(new Date());
        movie.setRuntime(148);

        when(movieRepository.existsById("movieId")).thenReturn(true);
        when(movieRepository.save(any(Movie.class))).thenReturn(movie);

        Movie result = movieService.updateMovie("movieId", movie);

        assertNotNull(result);
        assertEquals("Inception", result.getTitle());
        verify(movieRepository, times(1)).existsById("movieId");
        verify(movieRepository, times(1)).save(any(Movie.class));
    }

    @Test
    public void testDeleteMovie() {
        doNothing().when(movieRepository).deleteById("movieId");

        movieService.deleteMovie("movieId");

        verify(movieRepository, times(1)).deleteById("movieId");
    }

    @Test
    public void testSearchMoviesByTitle() {
        Movie movie = new Movie();
        movie.setTitle("Inception");
        movie.setReleaseDate(new Date());
        movie.setRuntime(148);
        List<Movie> movieList = List.of(movie);

        when(movieRepository.findByTitleContaining("Inception")).thenReturn(movieList);

        List<Movie> result = movieService.searchMoviesByTitle("Inception");

        assertFalse(result.isEmpty());
        assertEquals(1, result.size());
        assertEquals("Inception", result.get(0).getTitle());
        verify(movieRepository, times(1)).findByTitleContaining("Inception");
    }

    @Test
    public void testSearchMoviesByReleaseDate() {
        Movie movie = new Movie();
        movie.setTitle("Inception");
        movie.setReleaseDate(new Date());
        movie.setRuntime(148);
        List<Movie> movieList = List.of(movie);

        when(movieRepository.findByReleaseDate("2010-07-16")).thenReturn(movieList);

        List<Movie> result = movieService.searchMoviesByReleaseDate("2010-07-16");

        assertFalse(result.isEmpty());
        assertEquals(1, result.size());
        assertEquals("Inception", result.get(0).getTitle());
        verify(movieRepository, times(1)).findByReleaseDate("2010-07-16");
    }
}