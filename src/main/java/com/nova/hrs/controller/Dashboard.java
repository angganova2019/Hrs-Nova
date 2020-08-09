package com.nova.hrs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Dashboard {

    @GetMapping("/")
    public String index() {
        return "dashboard/index";
    }
}
