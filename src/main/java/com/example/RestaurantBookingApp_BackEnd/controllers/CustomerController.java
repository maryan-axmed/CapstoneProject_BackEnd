package com.example.RestaurantBookingApp_BackEnd.controllers;


import com.example.RestaurantBookingApp_BackEnd.models.Booking;
import com.example.RestaurantBookingApp_BackEnd.models.Customer;
import com.example.RestaurantBookingApp_BackEnd.models.CustomerDTO;
import com.example.RestaurantBookingApp_BackEnd.models.Restaurant;
import com.example.RestaurantBookingApp_BackEnd.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping(value = "/{customerId}")
    public ResponseEntity<CustomerDTO> getCustomerById(@PathVariable Long customerId){
        CustomerDTO customerDTO = customerService.getCustomerById(customerId);
        return new ResponseEntity<>(customerDTO, HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<CustomerDTO>> getAllCustomers(){
        List<CustomerDTO> customer = customerService.getAllCustomers();
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }


//    post/customers/id/bookings
//    this is the post mapping to view one customers' booking ( basically the wallet)

//    @PatchMapping(value="/{customerId}/bookings")
//    public ResponseEntity<List<Booking>> getAllBookingsFromCustomer(@RequestBody BookingDTO bookingDTO @PathVariable Long customerId){
//        List<Booking> customersBookings =
//    }


//    EXTENSTION : IF CONSIDERING MULTIPLE CUSTOMERS
//
//    @GetMapping
//    public ResponseEntity<List<Customer>> getAllCustomers(){
//        List<Customer> customers = customerService.getAllCustomers();
//        return new ResponseEntity<>(customers, HttpStatus.OK);
//    }








}
