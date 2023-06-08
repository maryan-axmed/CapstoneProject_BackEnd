package com.example.RestaurantBookingApp_BackEnd.components;


import com.example.RestaurantBookingApp_BackEnd.models.Booking;
import com.example.RestaurantBookingApp_BackEnd.models.Customer;
import com.example.RestaurantBookingApp_BackEnd.models.Restaurant;
import com.example.RestaurantBookingApp_BackEnd.models.Table;
import com.example.RestaurantBookingApp_BackEnd.repositories.BookingRepository;
import com.example.RestaurantBookingApp_BackEnd.repositories.CustomerRepository;
import com.example.RestaurantBookingApp_BackEnd.repositories.RestaurantRepository;
import com.example.RestaurantBookingApp_BackEnd.repositories.TableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    RestaurantRepository restaurantRepository;

    @Autowired
    TableRepository tableRepository;



    public DataLoader(){

    }

    @Override
    public void run(ApplicationArguments args) throws Exception{


//        make 6 restaurants

        Restaurant restaurant1 = new Restaurant("Nandos", "London");
        Restaurant restaurant2 = new Restaurant("Wagamama", "London");
        Restaurant restaurant3 = new Restaurant("An-Najeeb", "Leicester");
        Restaurant restaurant4 = new Restaurant("Konak", "Leicester");
        Restaurant restaurant5 = new Restaurant("PizzaExpress", "Edinburgh");
        Restaurant restaurant6 = new Restaurant("Herron", "Edinburgh");
        Restaurant restaurant7 = new Restaurant("Watan", "London");
        Restaurant restaurant8 = new Restaurant("Chaiwala", "Edinburgh");



//        make 1 customer

        Customer customer1 = new Customer("Yasmin", "yasmin@hotmail.com");
        Customer customer2 = new Customer("Sarah", "sarah@hotmail.com");
        Customer customer3 = new Customer("Taliane", "taliane@hotmail.com");




//        create tables

        Table table1 = new Table(4 ,restaurant2);
        Table table2 = new Table(6 ,restaurant2);
        Table table3 = new Table(8 ,restaurant2);
        Table table4 = new Table(12 ,restaurant2);
        Table table5 = new Table(2 ,restaurant2);

        Table table6 = new Table(4 ,restaurant1);
        Table table7 = new Table(6 ,restaurant1);
        Table table8 = new Table(8 ,restaurant1);
        Table table9 = new Table(12 ,restaurant1);
        Table table10 = new Table(2 ,restaurant1);


//        create bookings

        Booking booking1 = new Booking(customer1, restaurant2, LocalDateTime.of(2023,12,03 ,14, 00));
        Booking booking2 = new Booking(customer2, restaurant1, LocalDateTime.of(2023,12,03 ,16, 00));
        Booking booking3 = new Booking(customer3, restaurant2, LocalDateTime.of(2023,12,03 ,18, 00));


    }









}
