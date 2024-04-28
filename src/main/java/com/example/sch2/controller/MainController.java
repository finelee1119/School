package com.example.sch2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/sch2")
    public String showMainView() {
        return "main";
    }
}
