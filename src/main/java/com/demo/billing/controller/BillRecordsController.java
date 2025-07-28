package com.demo.billing.controller;

import com.demo.billing.calculation.BillCalculation;
import com.demo.billing.model.BillRecords;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.demo.billing.service.BillRecordService;
import java.util.List;

@RestController
@RequestMapping("/billRecords")
public class BillRecordsController {

    @Autowired
    private BillRecordService billRecordService;

    @Autowired
    private BillCalculation billCalculation;

    @PostMapping("/bill")
    public boolean generateBill(@RequestParam int customerId, @RequestParam double unitsConsumed) {
        double billAmount = billCalculation.calculateBill(unitsConsumed);
        BillRecords billRecords = new BillRecords(customerId, billAmount);
        return billRecordService.insertBillRecord(billRecords);
    }

    @GetMapping("/allBills")
    public String getAllBillRecords(Model model) {
        model.addAttribute("billRecords", billRecordService.getAllBillRecords());
        return "bills";
    }

    @GetMapping("/highestPaying")
    public BillRecords getHighestPayingCustomer(){
        return billRecordService.getHighestPayingCustomer();
    }
}
