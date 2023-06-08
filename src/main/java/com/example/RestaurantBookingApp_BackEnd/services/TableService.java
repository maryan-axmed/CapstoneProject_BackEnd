package com.example.RestaurantBookingApp_BackEnd.services;

import com.example.RestaurantBookingApp_BackEnd.models.Restaurant;
import com.example.RestaurantBookingApp_BackEnd.models.Table;
import com.example.RestaurantBookingApp_BackEnd.repositories.RestaurantRepository;
import com.example.RestaurantBookingApp_BackEnd.repositories.TableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TableService {
    @Autowired
    TableRepository tableRepository;
    @Autowired
    RestaurantRepository restaurantRepository;

    public List<Table> getAllTables() {
        return tableRepository.findAll();
    }

    public Table getTableById(Long tableId) {
        return tableRepository.findById(tableId).get();
    }

    public List<Table> getAllTablesByRestaurantId(Long restaurantId) {
//        METHOD ONE:
//        get a restaurant given an id
        Restaurant restaurant = restaurantRepository.findById(restaurantId).get();
        return restaurant.getTables();

        //        METHOD TWO:
//        create new list
//        get all tables
//        for loop - loop through the list and add it to the new list if the id=restaurantId

    }
}
