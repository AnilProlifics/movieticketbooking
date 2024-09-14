package com.capstone.movieticketbookingsystem.springbootapi.controller;

import com.capstone.movieticketbookingsystem.entity.Showtime;
import com.capstone.movieticketbookingsystem.springbootapi.service.ShowtimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class ShowtimeController {

    private final ShowtimeService showtimeService;

    @Autowired
    public ShowtimeController(ShowtimeService showtimeService) {
        this.showtimeService = showtimeService;
    }

    /**
     * Create a new showtime.
     *
     * @param showtime the showtime to create
     * @return the ResponseEntity with status 200 (OK) and with body of the new showtime
     */
    @PostMapping("/showtime")
    public ResponseEntity<Showtime> saveShowtime(@RequestBody Showtime showtime) {
        Showtime newShowtime = showtimeService.saveShowtime(showtime);
        return ResponseEntity.ok(newShowtime);
    }

    /**
     * Get all showtimes.
     *
     * @return the ResponseEntity with status 200 (OK) and with body of the list of showtimes
     */
    @GetMapping("/showtimes")
    public List<Showtime> getAllShowtimes() {
        return showtimeService.getAllShowtimes();
    }

    /**
     * Get a showtime by ID.
     *
     * @param id the ID of the showtime to get
     * @return the ResponseEntity with status 200 (OK) and with body of the showtime, or with status 404 (Not Found) if the showtime does not exist
     */
    @GetMapping("/showtimes/{id}")
    public ResponseEntity<Showtime> getShowtimeById(@PathVariable Long id) {
        Optional<Showtime> showtime = showtimeService.getShowtimeById(id);
        return showtime.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * Update a showtime by ID.
     *
     * @param id the ID of the showtime to update
     * @param showtime the updated showtime
     * @return the ResponseEntity with status 200 (OK) and with body of the updated showtime, or with status 404 (Not Found) if the showtime does not exist
     */
    @PutMapping("/showtimes/{id}")
    public ResponseEntity<Showtime> updateShowtime(@PathVariable Long id, @RequestBody Showtime showtime) {
        Showtime updatedShowtime = showtimeService.updateShowtime(id, showtime);
        return ResponseEntity.ok(updatedShowtime);
    }

    /**
     * Delete a showtime by ID.
     *
     * @param id the ID of the showtime to delete
     * @return the ResponseEntity with status 200 (OK) and with body of the message "Showtime deleted successfully"
     */
    @DeleteMapping("/showtimes/{id}")
    public ResponseEntity<String> deleteShowtime(@PathVariable Long id) {
        showtimeService.deleteShowtime(id);
        return ResponseEntity.ok("Showtime deleted successfully");
    }
}