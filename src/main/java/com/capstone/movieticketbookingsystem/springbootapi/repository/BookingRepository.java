package com.capstone.movieticketbookingsystem.springbootapi.repository;

import com.capstone.movieticketbookingsystem.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for Booking entity.
 */
@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
}