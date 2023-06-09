package com.example.RestaurantBookingApp_BackEnd.services;

import com.example.RestaurantBookingApp_BackEnd.models.*;
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
    public CustomerDTO getCustomerById(Long customerId) {
        Customer customer = customerRepository.findById(customerId).get();
        CustomerDTO customerDTO = getCustomerDTO(customer);
        return customerDTO;
    }

    public CustomerDTO getCustomerDTO(Customer customer) {
        List<Long> bookingIds = new ArrayList<>();
        for (Booking booking: customer.getBookings()) {
            Long id = booking.getId();
            bookingIds.add(id);
        }
        CustomerDTO customerDTO = new CustomerDTO(customer.getId(),customer.getName(), customer.getEmail(), bookingIds);
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
}
