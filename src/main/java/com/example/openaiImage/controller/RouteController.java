package com.example.openaiImage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RouteController {

    @GetMapping("/imageview")
    public String imageview(){
        return "image"; // image.html
    }
}
