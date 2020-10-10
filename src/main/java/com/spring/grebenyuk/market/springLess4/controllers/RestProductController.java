package com.spring.grebenyuk.market.springLess4.controllers;

import com.spring.grebenyuk.market.springLess4.entities.Product;
import com.spring.grebenyuk.market.springLess4.services.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@AllArgsConstructor
public class RestProductController {
    private ProductService productService;

   /* @GetMapping
    public List<Product> getAllProducts() {
        return productService.findAll(null, null, 100, 0, 5).getContent();
    } */

    @GetMapping
    public List<Product> getFilter(Model model,
                            @RequestParam(defaultValue = "1", name = "p") Integer page,
                            @RequestParam(name = "title", required = false) String title,
                            @RequestParam(name = "min", required = false) Integer min,
                            @RequestParam(name = "max", required = false) Integer max){
        if(page < 1 || page == null){
            page = 1;
        }

        Page<Product> products = productService.findAll(title, min, max, page-1, 5);
        return products.getContent();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productService.findById(id).get();
    }

    @PostMapping
    public Product createProduct(@RequestBody Product p) {
        //p.setId(null);
        return productService.saveOrUpdate(p);
    }

    @PutMapping
    public Product updateProduct(@RequestBody Product p) {
        return productService.saveOrUpdate(p);
    }

    @DeleteMapping
    public void deleteAll() {
        productService.deleteAll();
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        productService.deleteById(id);
    }
}
