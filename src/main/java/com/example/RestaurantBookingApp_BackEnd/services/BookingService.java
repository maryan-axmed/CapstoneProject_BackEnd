package com.example.RestaurantBookingApp_BackEnd.services;

import com.example.RestaurantBookingApp_BackEnd.models.*;
import com.example.RestaurantBookingApp_BackEnd.repositories.BookingRepository;
import com.example.RestaurantBookingApp_BackEnd.repositories.CustomerRepository;
import com.example.RestaurantBookingApp_BackEnd.repositories.RestaurantRepository;
import com.example.RestaurantBookingApp_BackEnd.repositories.TableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookingService {

    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    RestaurantRepository restaurantRepository;

    @Autowired
    TableRepository tableRepository;

    //Default constructor ???


    public List<Booking> getAllBookings(){
        return  bookingRepository.findAll();
    }


    public Booking getBookingById (Long bookingId){
        return bookingRepository.findById(bookingId).get();
    }

//    public void makeNewBooking(Long customerId, Long bookingId){
//        Optional<Booking> booking =  bookingRepository.findById(bookingId);
//        Optional<Customer> customer = customerRepository.findById(customerId);
//    }

    public void makeNewBooking(BookingDTO bookingDTO){
        // make new booking object and get the customer name and the dateAndTime

        //add customer object to the new booking object:
        Customer customer = customerRepository.findById(bookingDTO.getCustomerId()).get();

        //add restaurant object to the new booking object:
        Restaurant restaurant = restaurantRepository.findById(bookingDTO.getRestaurantId()).get();

        //add time and date??- need to add a 2-hour slot
        LocalTime time = bookingDTO.getTime();
        LocalDate date = bookingDTO.getDate();

        List<Table> listTable = new ArrayList<>();

        Table table1 = new Table();
        listTable.add(table1);

        Booking booking = new Booking(customer, restaurant, listTable, date, time);
        booking.setListOfTables(listTable);
        bookingRepository.save(booking);

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
