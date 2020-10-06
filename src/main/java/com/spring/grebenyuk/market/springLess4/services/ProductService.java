package com.spring.grebenyuk.market.springLess4.services;

import com.spring.grebenyuk.market.springLess4.entities.Product;
import com.spring.grebenyuk.market.springLess4.repositories.ProductRepository;
import com.spring.grebenyuk.market.springLess4.spesifications.ProductSpecific;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@AllArgsConstructor
public class ProductService {
    private ProductRepository productRepository;

    public Page<Product> findAll(String title, Integer min, Integer max, int page, int size){
        Specification<Product> spec = Specification.where(null);
        if(min != null){
            spec = spec.and(ProductSpecific.priceGreaterOrEqualsThan(min));
        }
        if(max != null){
            spec = spec.and(ProductSpecific.priceLessOrEqualsThan(max));
        }
        if(title != null && !title.isEmpty()){
            spec = spec.and(ProductSpecific.titleLike(title));
        }
        return productRepository.findAll(spec, PageRequest.of(page, size));
    }

    public Optional<Product> findById(Long id){
        return productRepository.findById(id);
    }

    public Product saveOrUpdate(Product product) {
        return productRepository.save(product);
    }
}
