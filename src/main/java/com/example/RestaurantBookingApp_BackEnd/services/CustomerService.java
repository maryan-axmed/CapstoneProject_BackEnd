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
        CustomerDTO customerDTO = getCustomerDTO(customer);;
        String location = customerDTO.getLocation();
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

    public List<CustomerDTO> getAllCustomers() {
        List<CustomerDTO> customerDTOs = new ArrayList<>();
        List<Customer> allCustomers = customerRepository.findAll();
        for(Customer customer: allCustomers) {
            CustomerDTO customerDTO = getCustomerDTO(customer);
            customerDTOs.add(customerDTO);
        }
        return customerDTOs;
    }

    public CustomerDTO editCustomerLocation(Long customerId, String newLocation) {
        Customer customer = customerRepository.findById(customerId).get();
        customer.setLocation(newLocation);
        customerRepository.save(customer);

        CustomerDTO customerDTO = getCustomerDTO(customer);
        customerDTO.setLocation(newLocation);
        return customerDTO;

    }

    public List<BookingDTO> getAllBookingsByCustomerId(Long customerId) {
        List<BookingDTO> allBookings  = new ArrayList<>();

        List<BookingDTO> bookings = bookingService.getAllBookings();
        for(BookingDTO booking: bookings) {
            Long customersId = booking.getCustomerId();
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
