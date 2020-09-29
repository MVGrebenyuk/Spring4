package com.spring.grebenyuk.market.springLess4.services;

import com.spring.grebenyuk.market.springLess4.dto.ProductDto;
import com.spring.grebenyuk.market.springLess4.entities.Product;
import com.spring.grebenyuk.market.springLess4.repositories.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@AllArgsConstructor
public class ProductService {

    private ProductRepository productRepository;

    public Page<Product> findAll(int page, int size){
        return productRepository.findAll(PageRequest.of(page, size));
    }

    public Product findMin(){
        List<Product> list= new ArrayList<>();
        list = productRepository.findAll();
        Collections.sort(list, Product::compareTo);
        return list.get(0);
    }

    public Product findMax(){
        List<Product> list= new ArrayList<>();
        list = productRepository.findAll();
        Collections.sort(list);
        return list.get(list.size()-1);
    }

    public List<Product> findMaxAndMin(int min, int max) {
        List<Product> list = new ArrayList<>();
        list = productRepository.findAll();
        Collections.sort(list);
        List<Product> finalList = new ArrayList<>();
        for (Product product : list) {
            if (product.getPrice() >= min && product.getPrice() <= max) {
                finalList.add(product);
            }
        }
        return finalList;
    }

    public Optional<Product> findById(Long id){
        return productRepository.findById(id);
    }

    public Optional<ProductDto> findDtoById(Long id){
        return productRepository.findOneById(id);
    }
}
