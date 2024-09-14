package com.capstone.movieticketbookingsystem.springbootapi.controller;

import com.capstone.movieticketbookingsystem.entity.Theater;
import com.capstone.movieticketbookingsystem.springbootapi.service.TheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class TheaterController {

    private final TheaterService theaterService;

    @Autowired
    public TheaterController(TheaterService theaterService) {
        this.theaterService = theaterService;
    }

    /**
     * Create a new theater.
     *
     * @param theater the theater to create
     * @return the ResponseEntity with status 200 (OK) and with body of the new theater
     */
    @PostMapping("/theater")
    public ResponseEntity<Theater> saveTheater(@RequestBody Theater theater) {
        Theater newTheater = theaterService.saveTheater(theater);
        return ResponseEntity.ok(newTheater);
    }

    /**
     * Get all theaters.
     *
     * @return the ResponseEntity with status 200 (OK) and with body of the list of theaters
     */
    @GetMapping("/theaters")
    public List<Theater> getAllTheaters() {
        return theaterService.getAllTheaters();
    }

    /**
     * Get a theater by ID.
     *
     * @param id the ID of the theater to get
     * @return the ResponseEntity with status 200 (OK) and with body of the theater, or with status 404 (Not Found) if the theater does not exist
     */
    @GetMapping("/theaters/{id}")
    public ResponseEntity<Theater> getTheaterById(@PathVariable Long id) {
        Optional<Theater> theater = theaterService.getTheaterById(id);
        return theater.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * Update a theater by ID.
     *
     * @param id the ID of the theater to update
     * @param theater the updated theater
     * @return the ResponseEntity with status 200 (OK) and with body of the updated theater, or with status 404 (Not Found) if the theater does not exist
     */
    @PutMapping("/theaters/{id}")
    public ResponseEntity<Theater> updateTheater(@PathVariable Long id, @RequestBody Theater theater) {
        Theater updatedTheater = theaterService.updateTheater(id, theater);
        return ResponseEntity.ok(updatedTheater);
    }

    /**
     * Delete a theater by ID.
     *
     * @param id the ID of the theater to delete
     * @return the ResponseEntity with status 200 (OK) and with body of the message "Theater deleted successfully"
     */
    @DeleteMapping("/theaters/{id}")
    public ResponseEntity<String> deleteTheater(@PathVariable Long id) {
        theaterService.deleteTheater(id);
        return ResponseEntity.ok("Theater deleted successfully");
    }
}