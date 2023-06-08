package com.example.RestaurantBookingApp_BackEnd.repositories;

import com.example.RestaurantBookingApp_BackEnd.models.Table;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TableRepository extends JpaRepository<Table, Long> {
}
