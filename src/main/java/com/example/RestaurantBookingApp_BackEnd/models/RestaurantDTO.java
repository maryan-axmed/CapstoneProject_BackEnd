package com.example.RestaurantBookingApp_BackEnd.models;

import java.util.List;

public class RestaurantDTO {
    private Long id;
    private String name;
    private List<Long> tableIds;
    private String location;
    private List<Long> bookingIds;

//    CONSTRUCTOR
    public RestaurantDTO(Long id, String name, List tableIds, String location, List bookingIds){
        this.id = id;
        this.name = name;
        this.tableIds = tableIds;
        this.location = location;
        this.bookingIds = bookingIds;
    }
//    DEFAULT CONSTRUCTOR
    public RestaurantDTO(){

    }
//    GETTERS AND SETTERS

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

    public List<Long> getTableIds() {
        return tableIds;
    }

    public void setTableIds(List<Long> tableIds) {
        this.tableIds = tableIds;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Long> getBookingIds() {
        return bookingIds;
    }

    public void setBookingIds(List<Long> bookingIds) {
        this.bookingIds = bookingIds;
    }
}
