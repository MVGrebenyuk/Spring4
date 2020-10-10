package com.spring.grebenyuk.market.springLess4.controllers;

import com.spring.grebenyuk.market.springLess4.entities.Product;
import com.spring.grebenyuk.market.springLess4.services.CartService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@Data
@RequestMapping("/cart")
@AllArgsConstructor
public class CartController {

    private List<Product> prodList;
    private CartService service;

    @GetMapping
    public String showCartList(Model model) {
        prodList = service.showProducts();
        model.addAttribute("cart", prodList);
        return "cart";
    }
}
