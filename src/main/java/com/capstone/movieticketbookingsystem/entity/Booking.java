package com.capstone.movieticketbookingsystem.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "booking")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long booking_id;

    @Column(nullable = false)
    private String booking_date;

    @Column(nullable = false)
    private String number_of_tickets;

    @Column(nullable = false)
    private String total_price;

    @ManyToOne
    @JoinColumn(name = "showtime_id")
    private Showtime showtime;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    // getters

    public Long getBooking_id() {
        return booking_id;
    }

    public String getBooking_date() {
        return booking_date;
    }

    public String getNumber_of_tickets() {
        return number_of_tickets;
    }

    public String getTotal_price() {
        return total_price;
    }

    public Showtime getShowtime() {
        return showtime;
    }

    public User getUser() {
        return user;
    }


// setters


    public void setBooking_id(Long booking_id) {
        this.booking_id = booking_id;
    }

    public void setBooking_date(String booking_date) {
        this.booking_date = booking_date;
    }

    public void setNumber_of_tickets(String number_of_tickets) {
        this.number_of_tickets = number_of_tickets;
    }

    public void setTotal_price(String total_price) {
        this.total_price = total_price;
    }

    public void setShowtime(Showtime showtime) {
        this.showtime = showtime;
    }

    public void setUser(User user) {
        this.user = user;
    }
}