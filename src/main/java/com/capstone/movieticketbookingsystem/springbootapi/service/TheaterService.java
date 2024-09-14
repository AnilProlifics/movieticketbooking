package com.capstone.movieticketbookingsystem.springbootapi.service;

import com.capstone.movieticketbookingsystem.entity.Theater;
import com.capstone.movieticketbookingsystem.springbootapi.repository.TheaterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service class for managing Theater entities.
 */
@Service
public class TheaterService {

    private final TheaterRepository theaterRepository;

    @Autowired
    public TheaterService(TheaterRepository theaterRepository) {
        this.theaterRepository = theaterRepository;
    }

    /**
     * Save a theater.
     *
     * @param theater the entity to save
     * @return the persisted entity
     */
    public Theater saveTheater(Theater theater) {
        return theaterRepository.save(theater);
    }

    /**
     * Get all the theaters.
     *
     * @return the list of entities
     */
    public List<Theater> getAllTheaters() {
        return theaterRepository.findAll();
    }

    /**
     * Get one theater by ID.
     *
     * @param id the ID of the entity
     * @return the entity
     */
    public Optional<Theater> getTheaterById(Long id) {
        return theaterRepository.findById(id);
    }

    /**
     * Update a theater.
     *
     * @param id the ID of the entity
     * @param updatedTheater the updated entity
     * @return the updated entity
     */
    public Theater updateTheater(Long id, Theater updatedTheater) {
        Optional<Theater> existingTheater = theaterRepository.findById(id);
        if (existingTheater.isPresent()) {
            Theater theater = existingTheater.get();
            theater.setName(updatedTheater.getName());
            theater.setLocation(updatedTheater.getLocation());
            theater.setCapacity(updatedTheater.getCapacity());

            return theaterRepository.save(theater);
        } else {
            throw new RuntimeException("Theater not found");
        }
    }

    /**
     * Delete the theater by ID.
     *
     * @param id the ID of the entity
     */
    public void deleteTheater(Long id) {
        theaterRepository.deleteById(id);
    }
}