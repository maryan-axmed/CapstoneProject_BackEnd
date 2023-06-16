package com.example.RestaurantBookingApp_BackEnd.controllers;

import com.example.RestaurantBookingApp_BackEnd.models.Table;
import com.example.RestaurantBookingApp_BackEnd.models.TableDTO;
import com.example.RestaurantBookingApp_BackEnd.services.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value= "/tables")
public class TableController {

    @Autowired
    TableService tableService;

    @GetMapping
    public ResponseEntity<List<Table>> getAllTables(){
        List<Table> tables = tableService.getAllTables();
        return new ResponseEntity<>(tables, HttpStatus.OK);
    }

    @GetMapping(value = "/{tableId}")
    public ResponseEntity<TableDTO> getTableById(@PathVariable Long tableId){
        TableDTO tableDTO = tableService.getTableById(tableId);
        return new ResponseEntity<>(tableDTO, HttpStatus.OK);
    }

    @GetMapping(value = "/restaurant/{restaurantId}")
    public ResponseEntity<List<Table>> getAllTablesByRestaurantId(@PathVariable Long restaurantId){
        List<Table> tables = tableService.getAllTablesByRestaurantId(restaurantId);
        return new ResponseEntity<>(tables, HttpStatus.OK);
    }







}
