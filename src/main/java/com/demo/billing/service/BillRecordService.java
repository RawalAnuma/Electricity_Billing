package com.demo.billing.service;

import com.demo.billing.model.BillRecords;
import com.demo.billing.model.Customer;
import com.demo.billing.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.demo.billing.repositories.BillRecordRepository;
import java.util.List;

@Service
public class BillRecordService {

    @Autowired
    BillRecordRepository billRecordRepository;

    @Autowired
    CustomerRepository customerRepository;

    public void insertBillRecord(BillRecords billRecords){
        int customerId = billRecords.getCustomer().getCustomerId();
        Customer customer = customerRepository.findById(customerId).orElseThrow(() -> new RuntimeException("Customer not found"));
        billRecords.setCustomer(customer);
        billRecordRepository.save(billRecords);
    }

    public List<BillRecords> getAllBillRecords(){
        return billRecordRepository.findAll();
    }

    public BillRecords getHighestPayingCustomer() {
        return billRecordRepository.findTopByOrderByBillAmountDesc();
    }
}
