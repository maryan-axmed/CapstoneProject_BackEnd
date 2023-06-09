package com.example.RestaurantBookingApp_BackEnd.services;

import com.example.RestaurantBookingApp_BackEnd.models.Booking;
import com.example.RestaurantBookingApp_BackEnd.models.Restaurant;
import com.example.RestaurantBookingApp_BackEnd.models.Table;
import com.example.RestaurantBookingApp_BackEnd.models.TableDTO;
import com.example.RestaurantBookingApp_BackEnd.repositories.RestaurantRepository;
import com.example.RestaurantBookingApp_BackEnd.repositories.TableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TableService {
    @Autowired
    TableRepository tableRepository;
    @Autowired
    RestaurantRepository restaurantRepository;

    public TableDTO getTableDTO(Table table){
        List<Long> bookingIds = new ArrayList<>();
        for (Booking booking: table.getListOfBookings()) {
            Long id = booking.getId();
            bookingIds.add(id);
        }
        TableDTO tableDTO = new TableDTO(table.getId(), table.getNumberOfSeats(), table.getRestaurant().getId(), bookingIds);
        return tableDTO;
    }

    public List<TableDTO> getAllTables() {
        List<TableDTO> tableDTOs = new ArrayList<>();
        List<Table> allTables = tableRepository.findAll();
        for (Table table: allTables){
            TableDTO tableDTO = getTableDTO(table);
            tableDTOs.add(tableDTO);
        }
        return tableDTOs;
    }

    public TableDTO getTableById(Long tableId) {
        Table table = tableRepository.findById(tableId).get();
        TableDTO tableDTO = getTableDTO(table);
        return tableDTO;
    }

    public List<TableDTO> getAllTablesByRestaurantId(Long restaurantId) {
//        METHOD ONE:
//        get a restaurant given an id
        Restaurant restaurant = restaurantRepository.findById(restaurantId).get();
        return restaurant.getTables();

        //        METHOD TWO:
//        create new tablelist
//        List<Table>

//        get all tables given restaurant
//        for loop - loop through the list and convert to DTO
//        for loop - add it to the new list if the id=restaurantId

    }
}
