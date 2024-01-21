package com.example.trip.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
//@ResponseBody //웹서버가 아닌 api 서버에서 움직임으로
public class MainController {

    @GetMapping("/")
    public String mainP() {

        return "HomePage";
    }
}
