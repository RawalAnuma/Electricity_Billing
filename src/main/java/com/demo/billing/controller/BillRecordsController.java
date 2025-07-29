package com.demo.billing.controller;

import com.demo.billing.calculation.BillCalculation;
import com.demo.billing.model.BillRecords;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.demo.billing.service.BillRecordService;


@Controller
@RequestMapping("/billRecords")
public class BillRecordsController {

    @Autowired
    private BillRecordService billRecordService;

    @Autowired
    private BillCalculation billCalculation;

    @GetMapping("/bill")
    public String generateBill(int customerId, double unitsConsumed){
        double billAmount = billCalculation.calculateBill(unitsConsumed);
        BillRecords billRecords = new BillRecords(customerId, billAmount);
        billRecordService.insertBillRecord(billRecords);
        return "calculateBill";
    }

    @GetMapping("/allBills")
    public String getAllBillRecords(Model model){
        model.addAttribute("billRecords", billRecordService.getAllBillRecords());
        return "bills";
    }

    @GetMapping("/highestPaying")
    public BillRecords getHighestPayingCustomer(){
        return billRecordService.getHighestPayingCustomer();
    }
}
