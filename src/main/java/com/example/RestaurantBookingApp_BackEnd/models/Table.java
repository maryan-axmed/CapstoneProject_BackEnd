package com.example.RestaurantBookingApp_BackEnd.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.List;

@Entity(name = "tables")
public class Table {

//    PROPERTIES

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Integer numberOfSeats;

    @ManyToOne
    @JsonIgnoreProperties({"tables"})
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;


    @ManyToMany(mappedBy ="listOfTables")
    @JsonIgnoreProperties({"listOfTables"})
    private List<Booking> listOfBookings;


//    CONSTRUCTOR

    public Table(Integer numberOfSeats, Restaurant restaurant){
        this.numberOfSeats = numberOfSeats;
        this.restaurant = restaurant;
    }

//    DEFAULT CONSTRUCTOR

    public Table(){

    }


//    GETTERS & SETTERS


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(Integer numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }
}
