package com.spring.grebenyuk.market.springLess4.repositories;

import com.spring.grebenyuk.market.springLess4.dto.ProductDto;
import com.spring.grebenyuk.market.springLess4.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<ProductDto> findOneById(Long id);
}
