package com.example.RestaurantBookingApp_BackEnd.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import javax.naming.Name;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "restaurants")
public class Restaurant {
//  PROPERTIES
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String name;

    @OneToMany(mappedBy = "restaurant")
    @JsonIgnoreProperties({"restaurant", "listOfBookings"})
//    @JoinColumn(name = "table_id")
    private List<Table> tables;

    @Column
    private String location;

    @OneToMany(mappedBy = "restaurant")
    @JsonIgnoreProperties({"restaurant", "customer", "listOfTables"})
//    @JoinColumn( name ="booking_id")
    private List<Booking> bookings;

    private String review;


//    EXT:
//    @Column
//    private String email;

//   CONSTRUCTOR
    public Restaurant(String name, String location, String review){
        this.location = location;
        this.name = name;
        this.bookings = new ArrayList<>();
        this.tables = new ArrayList<>();
        this.review= review;
    }

//   DEFAULT CONSTRUCTOR
    public Restaurant(){

    }

//  GETTERS AND SETTERS
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Table> getTables() {
        return tables;
    }

    public void setTables(List<Table> tables) {
        this.tables = tables;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }
}
