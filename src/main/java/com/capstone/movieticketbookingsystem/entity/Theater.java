package com.capstone.movieticketbookingsystem.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "theater")
public class Theater {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long theater_id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String location;

    @Column(nullable = false)
    private String capacity;

    @OneToMany (mappedBy = "theater", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Showtime> showtimes = new HashSet<>();

    // getters
    public Long getTheater_id() {
        return theater_id;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setShowtimes(Set<Showtime> showtimes) {
        this.showtimes = showtimes;
    }

    // setters
    public void setTheater_id(Long theater_id) {
        this.theater_id = theater_id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }
    public Set<Showtime> getShowtimes() {
        return showtimes;
    }
}