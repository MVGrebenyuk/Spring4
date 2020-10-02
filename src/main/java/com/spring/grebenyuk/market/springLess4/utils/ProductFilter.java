package com.spring.grebenyuk.market.springLess4.utils;

import com.spring.grebenyuk.market.springLess4.entities.Product;
import com.spring.grebenyuk.market.springLess4.spesifications.ProductSpecific;
import lombok.Getter;
import org.springframework.data.jpa.domain.Specification;

@Getter
public class ProductFilter {

    private Specification<Product> spec;
    private String filterDefinition;

    public ProductFilter(String title, Integer max, Integer min) {
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

    }
}
