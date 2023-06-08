package com.example.RestaurantBookingApp_BackEnd.controllers;


import com.example.RestaurantBookingApp_BackEnd.models.Restaurant;
import com.example.RestaurantBookingApp_BackEnd.models.Table;
import com.example.RestaurantBookingApp_BackEnd.services.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="/restaurants")
public class RestaurantController {

    @Autowired
    RestaurantService restaurantService;

    @GetMapping
    public ResponseEntity<List<Restaurant>> getAllRestaurants(){
        List<Restaurant> restaurants = restaurantService.getAllRestaurants();
        return new ResponseEntity<>(restaurants, HttpStatus.OK);
    }

    @GetMapping(value = "/{restaurantId}")
    public ResponseEntity<Restaurant>  getRestaurantById(@PathVariable Long restaurantId){
        Restaurant restaurant = restaurantService.getRestaurantById();
        return new ResponseEntity<>(restaurant, HttpStatus.OK);
    }







}
