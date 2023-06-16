package com.example.RestaurantBookingApp_BackEnd.controllers;


import com.example.RestaurantBookingApp_BackEnd.models.*;
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
    public ResponseEntity<List<Customer>> getAllCustomers(){
        List<Customer> customer = customerService.getAllCustomers();
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }
    @GetMapping(value = "/{customerId}/location")
    public ResponseEntity<String> getCustomerLocationById(@PathVariable Long customerId){
        String location = customerService.getCustomerLocationById(customerId);
        return new ResponseEntity<>(location, HttpStatus.OK);
    }

    @PatchMapping(value = "/{customerId}/location/edit")
    public ResponseEntity<Customer> editCustomerLocation(@PathVariable Long customerId, @RequestBody String newLocation){
        Customer customer = customerService.editCustomerLocation(customerId, newLocation);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }



//    post/customers/id/bookings
//    this is the post mapping to view one customers' booking ( basically the wallet)

    @GetMapping(value="/{customerId}/bookings")
    public ResponseEntity<List<Booking>> getAllBookingsByCustomerId(@PathVariable Long customerId) {
        List<Booking> customersBookings = customerService.getAllBookingsByCustomerId(customerId);
        return new ResponseEntity<>(customersBookings, HttpStatus.OK);
    }
//    @GetMapping(value="/{customerId}/bookings/{bookingId}")
//    public ResponseEntity<Booking> getBookingByCustomerId(@PathVariable Long customerId, @PathVariable Long bookingId) {
//        BookingDTO customerBooking = customerService.getBookingByCustomerId(customerId, bookingId);
//        return new ResponseEntity<>(customerBooking, HttpStatus.OK);
//    }


//    EXTENSTION : IF CONSIDERING MULTIPLE CUSTOMERS
//
//    @GetMapping
//    public ResponseEntity<List<Customer>> getAllCustomers(){
//        List<Customer> customers = customerService.getAllCustomers();
//        return new ResponseEntity<>(customers, HttpStatus.OK);
//    }








}
