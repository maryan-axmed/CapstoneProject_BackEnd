package com.example.RestaurantBookingApp_BackEnd.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.ArrayList;
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


    @ManyToMany(mappedBy ="listOfTables", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JsonIgnoreProperties({"listOfTables"})
    private List<Booking> listOfBookings;


//    CONSTRUCTOR

    public Table(Integer numberOfSeats, Restaurant restaurant){
        this.numberOfSeats = numberOfSeats;
        this.restaurant = restaurant;
        this.listOfBookings = new ArrayList<>();
    }

//    DEFAULT CONSTRUCTOR

    public Table(){
    }


//    GETTERS & SETTERS


    public List<Booking> getListOfBookings() {
        return listOfBookings;
    }

    public void setListOfBookings(List<Booking> listOfBookings) {
        this.listOfBookings = listOfBookings;
    }

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
