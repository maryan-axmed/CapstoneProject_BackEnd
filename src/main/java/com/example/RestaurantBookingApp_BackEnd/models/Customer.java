package com.example.RestaurantBookingApp_BackEnd.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity

@jakarta.persistence.Table(name = "customers")
public class Customer {
    // Customers have an ID, name, email address and a list of bookings
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    @Column
    private String name;
    @Column
    private String email;

    @JsonIgnoreProperties({"customers"})
    @ManyToMany
    @JoinTable(
            name = "customers_bookings",
            joinColumns = @JoinColumn(name = "customer_id"),
            inverseJoinColumns = @JoinColumn(name = "booking_id")
    )

    private List<Booking> bookings;

    public Customer(String name, String email ){
        this.name =name;
        this.email = email;
        this.bookings = new ArrayList<>();
    }
    public Customer(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }
}
