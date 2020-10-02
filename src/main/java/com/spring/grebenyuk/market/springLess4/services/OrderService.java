package com.spring.grebenyuk.market.springLess4.services;

import com.spring.grebenyuk.market.springLess4.entities.Order;
import com.spring.grebenyuk.market.springLess4.repositories.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;

@Service
@AllArgsConstructor
public class OrderService {

    private OrderRepository orderRepository;

    public List<Order> findAll(){
        return orderRepository.findAll();
    }
}
