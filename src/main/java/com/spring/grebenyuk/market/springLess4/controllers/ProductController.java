package com.spring.grebenyuk.market.springLess4.controllers;

import com.spring.grebenyuk.market.springLess4.dto.ProductDto;
import com.spring.grebenyuk.market.springLess4.entities.Customer;
import com.spring.grebenyuk.market.springLess4.entities.Product;
import com.spring.grebenyuk.market.springLess4.repositories.CustomerRepository;
import com.spring.grebenyuk.market.springLess4.services.ProductService;
import lombok.AllArgsConstructor;
import org.hibernate.mapping.Collection;
import org.springframework.beans.factory.annotation.Autowired;
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
    public String showAllProducts(Model model, @RequestParam(defaultValue = "1", name = "p") Integer page){
        if(page < 1){
            page = 1;
        }
        model.addAttribute("products", productService.findAll(page-1, 10));
        return "products";
    }
    @GetMapping("/min")
    @ResponseBody
    public Product showMin(Model model){
        return productService.findMin();
    }
    @GetMapping("/max")
    @ResponseBody
    public Product showMax(Model model){
        return productService.findMax();
    }
    @GetMapping("/price")
    @ResponseBody
    public List<Product> showMinMax(Model model,
                                    @RequestParam(name = "min") Integer min,
                                    @RequestParam(name = "max") Integer max){
        return productService.findMaxAndMin(min, max);
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ProductDto showProducts(Model model, @PathVariable Long id){
        return productService.findDtoById(id).get();
    }
}
