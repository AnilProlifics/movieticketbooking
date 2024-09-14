package com.capstone.movieticketbookingsystem.springbootapi.service;

import com.capstone.movieticketbookingsystem.entity.Showtime;
import com.capstone.movieticketbookingsystem.springbootapi.repository.ShowtimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service class for managing Showtime entities.
 */
@Service
public class ShowtimeService {

    private final ShowtimeRepository showtimeRepository;

    @Autowired
    public ShowtimeService(ShowtimeRepository showtimeRepository) {
        this.showtimeRepository = showtimeRepository;
    }

    /**
     * Save a showtime.
     *
     * @param showtime the entity to save
     * @return the persisted entity
     */
    public Showtime saveShowtime(Showtime showtime) {
        return showtimeRepository.save(showtime);
    }

    /**
     * Get all the showtimes.
     *
     * @return the list of entities
     */
    public List<Showtime> getAllShowtimes() {
        return showtimeRepository.findAll();
    }

    /**
     * Get one showtime by ID.
     *
     * @param id the ID of the entity
     * @return the entity
     */
    public Optional<Showtime> getShowtimeById(Long id) {
        return showtimeRepository.findById(id);
    }

    /**
     * Update a showtime.
     *
     * @param id the ID of the entity
     * @param updatedShowtime the updated entity
     * @return the updated entity
     */
    public Showtime updateShowtime(Long id, Showtime updatedShowtime) {
        Optional<Showtime> existingShowtime = showtimeRepository.findById(id);
        if (existingShowtime.isPresent()) {
            Showtime showtime = existingShowtime.get();
            showtime.setShow_date(updatedShowtime.getShow_date());
            showtime.setShow_time(updatedShowtime.getShow_time());

            return showtimeRepository.save(showtime);
        } else {
            throw new RuntimeException("Showtime not found");
        }
    }

    /**
     * Delete the showtime by ID.
     *
     * @param id the ID of the entity
     */
    public void deleteShowtime(Long id) {
        showtimeRepository.deleteById(id);
    }
}