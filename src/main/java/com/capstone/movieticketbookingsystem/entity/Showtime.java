package com.capstone.movieticketbookingsystem.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "showtime")
public class Showtime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long showtime_id;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;

    @ManyToOne
    @JoinColumn(name = "theater_id")
    private Theater theater;

    @Column(nullable = false)
    private String show_date;

    @Column(nullable = false)
    private String show_time;

    @OneToMany (mappedBy = "showtime", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Booking> bookings = new HashSet<>();

    // getters


    public Long getShowtime_id() {
        return showtime_id;
    }

    public Movie getMovie() {
        return movie;
    }


    public String getShow_date() {
        return show_date;
    }

    public String getShow_time() {
        return show_time;
    }

    public Theater getTheater() {
        return theater;
    }

    public Set<Booking> getBookings() {
        return bookings;
    }


    // setters

    public void setShowtime_id(Long showtime_id) {
        this.showtime_id = showtime_id;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public void setShow_date(String show_date) {
        this.show_date = show_date;
    }

    public void setShow_time(String show_time) {
        this.show_time = show_time;
    }

    public void setTheater(Theater theater) {
        this.theater = theater;
    }

    public void setBookings(Set<Booking> bookings) {
        this.bookings = bookings;
    }
}