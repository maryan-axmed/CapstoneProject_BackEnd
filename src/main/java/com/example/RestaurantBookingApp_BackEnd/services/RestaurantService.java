package com.example.RestaurantBookingApp_BackEnd.services;

import com.example.RestaurantBookingApp_BackEnd.models.Restaurant;
import com.example.RestaurantBookingApp_BackEnd.repositories.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RestaurantService {
    @Autowired
    RestaurantRepository restaurantRepository;

    public List<Restaurant> getAllRestaurants() {
        return restaurantRepository.findAll();
    }

    public Restaurant getRestaurantById(Long restaurantId) {
        return restaurantRepository.findById(restaurantId).get();
    }
}
