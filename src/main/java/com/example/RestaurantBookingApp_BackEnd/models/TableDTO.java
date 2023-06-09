package com.example.RestaurantBookingApp_BackEnd.models;

import java.util.List;

public class TableDTO {
    private Long id;
    private Integer numberOfSeats;
    private Long restaurantId;
    private List<Long> bookingIds;

//    CONSTRUCTOR
    public TableDTO(Long id, Integer numberOfSeats, Long restaurantId, List bookingIds){
        this.id = id;
        this.numberOfSeats = numberOfSeats;
        this.restaurantId = restaurantId;
        this.bookingIds = bookingIds;
    }

//    DEFAULT CONSTRUCTOR
    public TableDTO(){}

//    GETTERS AND SETTERS
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

    public Long getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Long restaurantId) {
        this.restaurantId = restaurantId;
    }

    public List<Long> getBookingIds() {
        return bookingIds;
    }

    public void setBookingIds(List<Long> bookingIds) {
        this.bookingIds = bookingIds;
    }
}
