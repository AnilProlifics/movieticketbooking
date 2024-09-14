package com.capstone.movieticketbookingsystem.springbootapi.controller;

import com.capstone.movieticketbookingsystem.entity.Movie;
import com.capstone.movieticketbookingsystem.springbootapi.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class MovieController {

    private final MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    /**
     * Create a new movie.
     *
     * @param movie the movie to create
     * @return the ResponseEntity with status 200 (OK) and with body of the new movie
     */
    @PostMapping("/movie")
    public ResponseEntity<Movie> saveMovie(@RequestBody Movie movie) {
        Movie newMovie = movieService.saveMovie(movie);
        return ResponseEntity.ok(newMovie);
    }

    /**
     * Get all movies.
     *
     * @return the ResponseEntity with status 200 (OK) and with body of the list of movies
     */
    @GetMapping("/movies")
    public List<Movie> getAllMovies() {
        return movieService.getAllMovies();
    }

    /**
     * Get a movie by ID.
     *
     * @param id the ID of the movie to get
     * @return the ResponseEntity with status 200 (OK) and with body of the movie, or with status 404 (Not Found) if the movie does not exist
     */
    @GetMapping("/movies/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable Long id) {
        Optional<Movie> movie = movieService.getMovieById(id);
        return movie.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * Update a movie by ID.
     *
     * @param id the ID of the movie to update
     * @param movie the updated movie
     * @return the ResponseEntity with status 200 (OK) and with body of the updated movie, or with status 404 (Not Found) if the movie does not exist
     */
    @PutMapping("/movies/{id}")
    public ResponseEntity<Movie> updateMovie(@PathVariable Long id, @RequestBody Movie movie) {
        Movie updatedMovie = movieService.updateMovie(id, movie);
        return ResponseEntity.ok(updatedMovie);
    }

    /**
     * Delete a movie by ID.
     *
     * @param id the ID of the movie to delete
     * @return the ResponseEntity with status 200 (OK) and with body of the message "Movie deleted successfully"
     */
    @DeleteMapping("/movies/{id}")
    public ResponseEntity<String> deleteMovie(@PathVariable Long id) {
        movieService.deleteMovie(id);
        return ResponseEntity.ok("Movie deleted successfully");
    }
}