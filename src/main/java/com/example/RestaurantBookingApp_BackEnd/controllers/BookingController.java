package com.example.RestaurantBookingApp_BackEnd.controllers;

import com.example.RestaurantBookingApp_BackEnd.models.Booking;
import com.example.RestaurantBookingApp_BackEnd.models.BookingDTO;
import com.example.RestaurantBookingApp_BackEnd.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("bookings")
public class BookingController {

    @Autowired
    BookingService bookingService;

    // GetMapping for getAllBookings

    @GetMapping
    public ResponseEntity<List<Booking>> getAllBookings(){
        List<Booking> bookings = bookingService.getAllBookings();
        return new ResponseEntity<>(bookings, HttpStatus.OK);
    }

    // GetMapping for getBookingById
    @GetMapping(value= "/{id}")
    public ResponseEntity<BookingDTO> getBookingById(@PathVariable Long id) {
        BookingDTO bookingDTO = bookingService.getBookingById(id);
//        if (booking.isPresent()) {
            return new ResponseEntity<>(bookingDTO, HttpStatus.OK);
        }
//        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
//    }

    // GetMapping for getAllBookingsByCustomerId
    @GetMapping(value= "/customer/{id}")
    public ResponseEntity<List<Booking>> getAllBookingsByCustomerId(@PathVariable Long id) {
        return new ResponseEntity<>(bookingService.getAllBookingsByCustomerId(id), HttpStatus.OK);
    }

    // PostMapping for makeNewBookings

    @PostMapping
    public ResponseEntity<Booking> makeNewBooking(@RequestBody BookingDTO bookingDTO){
        Booking booking = bookingService.makeNewBooking(bookingDTO);
        return new ResponseEntity<>(booking, HttpStatus.CREATED);
    }


    // DeleteMapping for DeleteBooking
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Long> deleteBooking(@PathVariable Long id) {
//        Booking booking = bookingService.getBookingById(id); // optional ?
        bookingService.deleteBooking(id);
//        if (!booking.isPresent()) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
//        }
//        return new ResponseEntity<>(id, HttpStatus.OK);
    }











    //
}



