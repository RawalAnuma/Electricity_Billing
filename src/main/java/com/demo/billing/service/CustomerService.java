package com.demo.billing.service;

import com.demo.billing.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.demo.billing.repositories.CustomerRepository;
import java.util.List;
import java.util.Optional;


@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public Customer insertCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public double calculateBill(double unitsConsumed) {
        double totalBill = 0;
        double remainingUnits = 0;

        if (unitsConsumed <= 10) {
            totalBill = 10 * unitsConsumed;
        } else if (unitsConsumed <= 30) {
            remainingUnits = unitsConsumed - 10;
            totalBill = (remainingUnits * (250.0 / 20.0)) + 100;
        } else {
            remainingUnits = unitsConsumed - 20 - 10;
            totalBill = (remainingUnits * 2) + 100 + 250;
        }
        return totalBill;
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Optional<Customer> getCustomerIdByNameAndHouseNumber(Customer customer){
        return customerRepository.findByCustomerNameAndHouseNumber(customer.getCustomerName(), customer.getHouseNumber());
    }

}
