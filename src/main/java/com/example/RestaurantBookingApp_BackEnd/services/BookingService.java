package com.example.RestaurantBookingApp_BackEnd.services;

import com.example.RestaurantBookingApp_BackEnd.models.Booking;
import com.example.RestaurantBookingApp_BackEnd.models.Customer;
import com.example.RestaurantBookingApp_BackEnd.repositories.BookingRepository;
import com.example.RestaurantBookingApp_BackEnd.repositories.CustomerRepository;
import com.example.RestaurantBookingApp_BackEnd.repositories.TableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookingService {

    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    TableRepository tableRepository;

    //Default constructor ???


    public List<Booking> getAllBookings(){
        return  bookingRepository.findAll();
    }


    public Booking getBookingById (Long bookingId){
        return bookingRepository.findById(bookingId).get();
    }

//incomplete??
//
    public void makeNewBooking(Long customerId, Long bookingId){
        Optional<Booking> booking =  bookingRepository.findById(bookingId);
        Optional<Customer> customer = customerRepository.findById(customerId);
    }

    public void deleteBooking(Long bookingId){
//        Booking booking = bookingRepository.findById(bookingId).get();
        bookingRepository.deleteById(bookingId);
    }


    public List<Booking> getAllBookingsByCustomerId(Long customerId) {
        Customer customer = customerRepository.findById(customerId).get();
        return  customer.getBookings();
    }
}
