package com.demo.billing.controller;

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


    @PostMapping
    public String saveBill(@ModelAttribute BillRecords billRecords){
        billRecordService.insertBillRecord(billRecords);
        return "Successfully saved!";
    }

    @GetMapping("/allBills")
    public String getAllBillRecords(@ModelAttribute BillRecords billRecords){
         billRecordService.getAllBillRecords();
        return "bills";
    }

    @GetMapping("/highestPaying")
    public BillRecords getHighestPayingCustomer(){
        return billRecordService.getHighestPayingCustomer();
    }
}
