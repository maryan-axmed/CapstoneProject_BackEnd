package com.example.RestaurantBookingApp_BackEnd.repositories;

import com.example.RestaurantBookingApp_BackEnd.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
