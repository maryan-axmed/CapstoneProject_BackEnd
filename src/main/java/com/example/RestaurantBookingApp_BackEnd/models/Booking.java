package com.example.RestaurantBookingApp_BackEnd.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@jakarta.persistence.Table(name = "bookings")
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
    @OneToMany
    @JsonIgnoreProperties({"tables", "bookings"})
    @JoinColumn(name="restaurant_id")
    private Restaurant restaurant;

    @Column
    private List<Table> listOfTables;

    @Column
    private LocalDateTime dateAndTime;

//    CONSTRUCTOR- for the booking model

    public Booking(Customer customer, Restaurant restaurant, LocalDateTime dateAndTime){
        this.customer = customer;
        this.restaurant = restaurant;
        this.listOfTables = new ArrayList<>();
        this.dateAndTime = dateAndTime;
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
}
