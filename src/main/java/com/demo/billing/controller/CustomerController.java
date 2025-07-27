package com.demo.billing.controller;

import com.demo.billing.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.CustomerService;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;


    @PostMapping
    public boolean addCustomer(@RequestParam String customerName, @RequestParam int houseNumber, @RequestParam double unitsConsumed){
        Customer customer = new Customer(customerName, houseNumber, unitsConsumed);
        return customerService.insertCustomer(customer);
    }

    @GetMapping("/all")
    public List<Customer> getAllCustomers(){
        return customerService.getAllCustomers();
    }

    @GetMapping("/id")
    public int getCustomerId(@RequestParam String customerName, @RequestParam int houseNumber, @RequestParam double unitsConsumed){
    Customer customer = new Customer(customerName, houseNumber, unitsConsumed);
    Optional<Customer> optionalCustomer = customerService.getCustomerIdByNameAndHouseNumber(customer);
    return optionalCustomer.orElseThrow(() -> new RuntimeException("Customer not found")).getCustomerId();
    }
}
