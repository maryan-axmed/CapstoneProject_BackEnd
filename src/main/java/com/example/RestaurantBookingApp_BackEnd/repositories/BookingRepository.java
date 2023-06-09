package com.example.RestaurantBookingApp_BackEnd.repositories;

import com.example.RestaurantBookingApp_BackEnd.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {

}
