package com.demo.billing.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class ViewController {

    @GetMapping("/home")
    public String viewHomePage(){
        return "home";
    }

    @GetMapping("/customer")
    public String viewCustomerPage() {
        return "showCustomers";
    }

    @GetMapping("/calculateBill")
    public String calculateBillPage() {
        return "calculateBill";
    }

   @GetMapping("/billRecords")
    public String viewBillPage() {
      return "bills";
    }


}
