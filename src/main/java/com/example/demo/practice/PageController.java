package com.example.demo.practice;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping("/calculator")
    public String calculator() {
        return "forward:/calculator.html";
    } 

    @GetMapping("/employee-management")
    public String employeeManagement() {
        return "forward:/employee.html";
    }
}