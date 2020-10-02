package com.spring.grebenyuk.market.springLess4.controllers;

import com.spring.grebenyuk.market.springLess4.dto.ProductDto;
import com.spring.grebenyuk.market.springLess4.entities.Customer;
import com.spring.grebenyuk.market.springLess4.entities.Product;
import com.spring.grebenyuk.market.springLess4.repositories.CustomerRepository;
import com.spring.grebenyuk.market.springLess4.services.ProductService;
import lombok.AllArgsConstructor;
import org.hibernate.mapping.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@Controller
@RequestMapping("/products")
@AllArgsConstructor
public class ProductController {
    private ProductService productService;

    @GetMapping
    public String getFilter(Model model,
                                    @RequestParam(defaultValue = "1", name = "p") Integer page,
                                    @RequestParam(name = "title", required = false) String title,
                                    @RequestParam(name = "min", required = false) Integer min,
                                    @RequestParam(name = "max", required = false) Integer max){
        if(page < 1 || page == null){
            page = 1;
        }

        Page<Product> products = productService.findAll(title, min, max, page-1, 5);
        model.addAttribute("products", products);
        return "products";
    }

    /*@GetMapping("/{id}")
    @ResponseBody
    public ProductDto showProducts(Model model, @PathVariable Long id){
        return productService.findDtoById(id).get();
    }*/
}
