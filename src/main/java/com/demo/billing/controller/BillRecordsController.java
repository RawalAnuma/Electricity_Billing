package com.demo.billing.controller;

import com.demo.billing.model.BillRecords;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.demo.billing.service.BillRecordService;

import java.util.List;


@Controller
@RequestMapping("/billRecords")
public class BillRecordsController {

    @Autowired
    private BillRecordService billRecordService;


    @PostMapping
    public String saveBill(@ModelAttribute BillRecords billRecords){
        billRecordService.insertBillRecord(billRecords);
        return "redirect:/billRecords/allBills";
    }

    @GetMapping("/allBills")
    public String getAllBillRecords(Model model){
        List<BillRecords> billList = billRecordService.getAllBillRecords();
        model.addAttribute("billRecords", billList);
        return "bills";
    }

    @GetMapping("/highestPaying")
    public BillRecords getHighestPayingCustomer(){
        return billRecordService.getHighestPayingCustomer();
    }
}
