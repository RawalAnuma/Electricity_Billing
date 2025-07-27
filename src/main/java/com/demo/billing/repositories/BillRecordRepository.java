package com.demo.billing.repositories;

import com.demo.billing.model.BillRecords;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillRecordRepository extends JpaRepository<BillRecords, Integer> {
    BillRecords findTopByOrderByBillAmountDesc(); // Method to find the highest paying customer
}
