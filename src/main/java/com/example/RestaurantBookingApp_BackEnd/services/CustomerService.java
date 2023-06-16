package com.example.RestaurantBookingApp_BackEnd.services;

import com.example.RestaurantBookingApp_BackEnd.models.*;
import com.example.RestaurantBookingApp_BackEnd.repositories.BookingRepository;
import com.example.RestaurantBookingApp_BackEnd.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {
    @Autowired
    BookingService bookingService;
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    BookingRepository bookingRepository;
    public CustomerDTO getCustomerById(Long customerId) {
        Customer customer = customerRepository.findById(customerId).get();
        CustomerDTO customerDTO = getCustomerDTO(customer);
        return customerDTO;
    }

    public String getCustomerLocationById(Long customerId){
        Customer customer = customerRepository.findById(customerId).get();
        String location = customer.getLocation();
        return location;
    }

//    public String setCustomerLocation(String newLocation){
//
//    }

    public CustomerDTO getCustomerDTO(Customer customer) {
        List<Long> bookingIds = new ArrayList<>();
        for (Booking booking: customer.getBookings()) {
            Long id = booking.getId();
            bookingIds.add(id);
        }
        CustomerDTO customerDTO = new CustomerDTO(customer.getId(),customer.getName(), customer.getEmail(), bookingIds, customer.getLocation());
        return customerDTO;
    }

    public List<Customer> getAllCustomers() {
        List<Customer> allCustomers = customerRepository.findAll();
        return allCustomers;
    }

    public Customer editCustomerLocation(Long customerId, String newLocation) {
        Customer customer = customerRepository.findById(customerId).get();
        customer.setLocation(newLocation);
        customerRepository.save(customer);
        return customer;

    }

    public List<Booking> getAllBookingsByCustomerId(Long customerId) {
        List<Booking> allBookings = new ArrayList<>();
        List<Booking> bookings = bookingService.getAllBookings();
        for(Booking booking: bookings) {
            Long customersId = booking.getCustomer().getId();
            if (customersId == customerId) {
                allBookings.add(booking);
            }
        }
        return allBookings;
    }



//    fix
//    public BookingDTO getBookingByCustomerId(Long customerId, Long bookingId) {
//        List<BookingDTO> bookingDTOS = bookingService.getAllBookings();
//        BookingDTO customerBooking = new BookingDTO();
//        for(BookingDTO booking: bookingDTOS) {
//            if (booking.getCustomerId()== customerId && booking.getId() == bookingId) {
//                customerBooking = bookingService.getBookingById(bookingId);
//            }
//        }
//        return customerBooking;
//    }
}
