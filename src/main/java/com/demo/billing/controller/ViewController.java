package com.demo.billing.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//@RequestMapping("/view")
public class ViewController {
    @GetMapping("/home")
    public String viewHomePage(){
        return "home";
    }

    @GetMapping("/calculateBill")
    public String calculateBillPage() {
        return "calculateBill";
    }

    @GetMapping("/showBills")
    public String viewBillPage() {
        return "bills";
    }

    @GetMapping("/about")
    public String aboutPage() {
        return "about";
    }
}
