package com.capstone.movieticketbookingsystem.springbootapi.repository;

import com.capstone.movieticketbookingsystem.entity.Showtime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for Showtime entity.
 */
@Repository
public interface ShowtimeRepository extends JpaRepository<Showtime, Long> {
}