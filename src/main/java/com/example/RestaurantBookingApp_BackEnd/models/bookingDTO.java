package com.example.RestaurantBookingApp_BackEnd.models;

import java.time.LocalDateTime;
import java.util.List;

public class bookingDTO {

    private Long id;
    private Long customerId;
    private String customerName;
    private List<Long> tableId;
    private Long restaurantId;
    private LocalDateTime dateAndTime;
    private String message;

//    CONSTRUCTOR
    public bookingDTO(Long customerId, String customerName, Long restaurantId, LocalDateTime dateAndTime){
        this.customerId = customerId;
        this.customerName = customerName;
        this.restaurantId = restaurantId;
        this.dateAndTime = dateAndTime;
        this.message = "";
    }

//    DEFAULT CONSTRUCTOR
    public bookingDTO(){

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

    public List<Long> getTableId() {
        return tableId;
    }

    public void setTableId(List<Long> tableId) {
        this.tableId = tableId;
    }

    public Long getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Long restaurantId) {
        this.restaurantId = restaurantId;
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
}
