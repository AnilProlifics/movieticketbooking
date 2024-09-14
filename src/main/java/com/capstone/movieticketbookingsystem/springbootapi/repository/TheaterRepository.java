package com.capstone.movieticketbookingsystem.springbootapi.repository;

import com.capstone.movieticketbookingsystem.entity.Theater;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for Theater entity.
 */
@Repository
public interface TheaterRepository extends JpaRepository<Theater, Long> {
}