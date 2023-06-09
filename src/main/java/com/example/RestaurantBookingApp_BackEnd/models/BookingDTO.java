package com.example.RestaurantBookingApp_BackEnd.models;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class BookingDTO {

    private Long id;
    private Long customerId;
    private String customerName;
    private List<Long> tableIds;
    private Long restaurantId;
    private LocalDateTime dateAndTime;
    private LocalDate date;
    private LocalTime time;
    private String message;

//    CONSTRUCTOR
//    CONSTRUCTOR should not have id??

    public BookingDTO(Long id,Long customerId, String customerName, Long restaurantId, List tableIds, String date, String time){
        this.id = id;
        this.customerId = customerId;
        this.customerName = customerName;
        this.tableIds = tableIds;
        this.restaurantId = restaurantId;
        this.date = LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy/mm/dd"));;
        this.time = LocalTime.parse(time, DateTimeFormatter.ofPattern("hh:mm"));;
        this.message = "";
    }

//    DEFAULT CONSTRUCTOR
    public BookingDTO(){

    }

//    GETTERS AND SETTERS:


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public List<Long> getTableIds() {
        return tableIds;
    }

    public void setTableIds(List<Long> tableId) {
        this.tableIds = tableId;
    }

    public Long getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Long restaurantId) {
        this.restaurantId = restaurantId;
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
}
