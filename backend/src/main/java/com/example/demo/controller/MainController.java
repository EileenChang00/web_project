package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
    @GetMapping(value = "/") // if route to root page, run this method
    @ResponseBody // show view
    public String index() { // this method will return String type

        return "<h1>Hi!</h1>";

    }
}
