package com.demo.billing.controller;


import com.demo.billing.model.BillRecords;
import com.demo.billing.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.demo.billing.service.CustomerService;
import java.util.Optional;

@Controller
@RequestMapping("/customer")
public class CustomerController{

    @Autowired
    private CustomerService customerService;



    @PostMapping
    public String addCustomer(@RequestParam String customerName, @RequestParam int houseNumber, @RequestParam double unitsConsumed) {
        Customer customer = new Customer(customerName, houseNumber, unitsConsumed);
        customerService.insertCustomer(customer);
        int customerId=customer.getCustomerId();
        return "redirect:/billRecords/bill?customerId="+customerId + "&unitsConsumed="+ unitsConsumed;
    }

    @GetMapping("/all")
    public String getAllCustomers(Model model){
        model.addAttribute("customer", customerService.getAllCustomers());
        return "showCustomers";
    }

    @PostMapping("/calculate")
    public String calculateBill(@ModelAttribute Customer customer, Model model){
        Customer savedCustomer = customerService.insertCustomer(customer);
        double billAmount = customerService.calculateBill(customer.getUnitsConsumed());
        BillRecords bill = new BillRecords();
        bill.setBillAmount(billAmount);
        bill.setCustomer(savedCustomer);
        model.addAttribute("billRecords", bill);
        return "home";

    }

    @GetMapping("/id")
    public int getCustomerId(@RequestParam String customerName, @RequestParam int houseNumber, @RequestParam double unitsConsumed){
        Customer customer = new Customer(customerName, houseNumber, unitsConsumed);
        Optional<Customer> optionalCustomer = customerService.getCustomerIdByNameAndHouseNumber(customer);
        return optionalCustomer.orElseThrow(() -> new RuntimeException("Customer not found")).getCustomerId();
    }
}
