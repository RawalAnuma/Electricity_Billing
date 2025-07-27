package com.demo.billing.repositories;

import com.demo.billing.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    Optional<Customer> findByCustomerNameAndHouseNumber(String customerName, int houseNumber);
}
