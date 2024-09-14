package com.capstone.movieticketbookingsystem.springbootapi.repository;

import com.capstone.movieticketbookingsystem.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for Movie entity.
 */
@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
}