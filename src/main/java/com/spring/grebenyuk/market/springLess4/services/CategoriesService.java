package com.spring.grebenyuk.market.springLess4.services;

import com.spring.grebenyuk.market.springLess4.entities.Category;
import com.spring.grebenyuk.market.springLess4.repositories.CategoriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriesService {
    private CategoriesRepository repository;

    @Autowired
    public void setRepository(CategoriesRepository repository) {
        this.repository = repository;
    }

    public List<Category> findAll(){
        return repository.findAll();
    }
}
