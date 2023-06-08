package com.example.RestaurantBookingApp_BackEnd.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "bookings")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

//    many to one => customer
    @ManyToOne
    @JsonIgnoreProperties({"listOfBookings"})
    @JoinColumn(name = "customer_id")
    private Customer customer;

//    one to many => restaurant
    @ManyToOne
    @JsonIgnoreProperties({"tables", "bookings"})
    @JoinColumn(name="restaurant_id")
    private Restaurant restaurant;

//    owner over table in the many-to-many rel
    @ManyToMany
    @JsonIgnoreProperties({"bookings"})
    @JoinTable(
            name="bookings_tables",
            joinColumns = {@JoinColumn(name="booking_id")},
            inverseJoinColumns = {@JoinColumn(name = "table_id")}
    )
    private List<Table> listOfTables;

    @Column
    private LocalDateTime dateAndTime;

    private String message;

//    CONSTRUCTOR- for the booking model

    public Booking(Customer customer, Restaurant restaurant, LocalDateTime dateAndTime){
        this.customer = customer;
        this.restaurant = restaurant;
        this.listOfTables = new ArrayList<>();
        this.dateAndTime = dateAndTime;
        this.message = "";
    }

//    DEFAULT CONSTRUCTOR
    public Booking(){

    }

//    GETTERS AND SETTERS:


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public List<Table> getListOfTables() {
        return listOfTables;
    }

    public void setListOfTables(List<Table> listOfTables) {
        this.listOfTables = listOfTables;
    }

    public LocalDateTime getDateAndTime() {
        return dateAndTime;
    }

    public void setDateAndTime(LocalDateTime dateAndTime) {
        this.dateAndTime = dateAndTime;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

//    public boolean isPresent() {
//    }
}
