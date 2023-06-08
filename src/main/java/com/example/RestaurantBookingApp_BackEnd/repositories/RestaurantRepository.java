package com.example.RestaurantBookingApp_BackEnd.repositories;

import com.example.RestaurantBookingApp_BackEnd.models.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
}
