package com.euntaek.BestSellerSpring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping("/")
    public String main(){
        return "main";
    }

    @GetMapping("/about")
    public String about(){
        return "aboutUs";
    }
}
