package com.demo.billing.controller;

import ch.qos.logback.core.model.Model;
import com.demo.billing.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.demo.billing.service.CustomerService;
import java.util.Optional;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;


    @PostMapping
    public boolean addCustomer(@RequestParam String customerName, @RequestParam int houseNumber, @RequestParam double unitsConsumed) {
        Customer customer = new Customer(customerName, houseNumber, unitsConsumed);
        return customerService.insertCustomer(customer);
    }

    @GetMapping("/all")
    public String getAllCustomers(Model model){
        model.addAttribute("customer", customerService.getAllCustomers());
        return "home";
    }


    @GetMapping("/id")
    public int getCustomerId(@RequestParam String customerName, @RequestParam int houseNumber, @RequestParam double unitsConsumed){
    Customer customer = new Customer(customerName, houseNumber, unitsConsumed);
    Optional<Customer> optionalCustomer = customerService.getCustomerIdByNameAndHouseNumber(customer);
    return optionalCustomer.orElseThrow(() -> new RuntimeException("Customer not found")).getCustomerId();
    }
}
