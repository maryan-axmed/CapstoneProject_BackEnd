package com.example.RestaurantBookingApp_BackEnd.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "bookings")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

//    many to one => customer
    @ManyToOne
    @JsonIgnoreProperties({"bookings"})
    @JoinColumn(name = "customer_id")
    private Customer customer;

//    one to many => restaurant
    @ManyToOne
    @JsonIgnoreProperties({"tables", "bookings"})
    @JoinColumn(name="restaurant_id")
    private Restaurant restaurant;

//    owner over table in the many-to-many rel
    @ManyToMany
    @JsonIgnoreProperties({"listOfBookings", "restaurant"})
    @JoinTable(
            name="bookings_tables",
            joinColumns = {@JoinColumn(name="booking_id")},
            inverseJoinColumns = {@JoinColumn(name = "table_id")}
    )
    private List<Table> listOfTables;

    @Column
//    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate date;

    @Column
//    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    private LocalTime time;

    private String message;

//    CONSTRUCTOR- for the booking model

    public Booking(Customer customer, Restaurant restaurant, List listOfTables, LocalDate date, LocalTime time){
        this.customer = customer;
        this.restaurant = restaurant;
        this.listOfTables = listOfTables;
        this.date = date;
        this.time = time;
        this.message = "";
    }

//    DEFAULT CONSTRUCTOR
    public Booking(){

    }



    public void addTable(Table table){
        this.listOfTables.add(table);
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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
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
