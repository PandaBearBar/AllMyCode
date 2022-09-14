package com.example.NoderDocker.controller;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("Noder")
public class MyCon {
    @GetMapping("/Docker")
    public String MyController (){
        return "Noder Docker !" ;
    }
}
