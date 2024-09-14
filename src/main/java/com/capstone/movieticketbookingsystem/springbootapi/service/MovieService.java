package com.capstone.movieticketbookingsystem.springbootapi.service;

import com.capstone.movieticketbookingsystem.entity.Movie;
import com.capstone.movieticketbookingsystem.springbootapi.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service class for managing Movie entities.
 */
@Service
public class MovieService {

    private final MovieRepository movieRepository;

    @Autowired
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    /**
     * Save a movie.
     *
     * @param movie the entity to save
     * @return the persisted entity
     */
    public Movie saveMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    /**
     * Get all the movies.
     *
     * @return the list of entities
     */
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    /**
     * Get one movie by ID.
     *
     * @param id the ID of the entity
     * @return the entity
     */
    public Optional<Movie> getMovieById(Long id) {
        return movieRepository.findById(id);
    }

    /**
     * Update a movie.
     *
     * @param id the ID of the entity
     * @param updatedMovie the updated entity
     * @return the updated entity
     */
    public Movie updateMovie(Long id, Movie updatedMovie) {
        Optional<Movie> existingMovie = movieRepository.findById(id);
        if (existingMovie.isPresent()) {
            Movie movie = existingMovie.get();
            movie.setTitle(updatedMovie.getTitle());
            movie.setDescription(updatedMovie.getDescription());
            movie.setGenre(updatedMovie.getGenre());
            movie.setDuration(updatedMovie.getDuration());
            movie.setRating(updatedMovie.getRating());

            return movieRepository.save(movie);
        } else {
            throw new RuntimeException("Movie not found");
        }
    }

    /**
     * Delete the movie by ID.
     *
     * @param id the ID of the entity
     */
    public void deleteMovie(Long id) {
        movieRepository.deleteById(id);
    }
}