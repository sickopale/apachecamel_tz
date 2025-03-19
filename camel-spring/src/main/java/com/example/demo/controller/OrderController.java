package com.example.demo.controller;

import com.example.demo.model.Order;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @PostMapping(consumes = MediaType.APPLICATION_XML_VALUE)
    public void doSmth(@RequestBody Order order){
        System.out.println(order);
    }

}
