package com.spring.grebenyuk.market.springLess4.repositories;

import com.spring.grebenyuk.market.springLess4.dto.ProductDto;
import com.spring.grebenyuk.market.springLess4.entities.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long>, JpaSpecificationExecutor<Product> {

    List<Product> findAllByPriceGreaterThanAndPriceLessThan(int min, int max, Pageable pageable);
    List<Product> findAllByPriceGreaterThan(int min, Pageable pageable);
    List<Product> findAllByPriceLessThan(int max, Pageable pageable);
    Product findProductById(Long id);

}
