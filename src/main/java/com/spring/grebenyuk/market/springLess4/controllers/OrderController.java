package com.spring.grebenyuk.market.springLess4.controllers;

import com.spring.grebenyuk.market.springLess4.entities.Order;
import com.spring.grebenyuk.market.springLess4.services.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/orders")
@AllArgsConstructor
public class OrderController {
    private OrderService orderService;
    List<Order> orderList = new ArrayList<>();

    @GetMapping
    public String firstRequest(Model model){
        orderList = orderService.findAll();
        model.addAttribute("orderes", orderList);
        return "orders";
    }
}
