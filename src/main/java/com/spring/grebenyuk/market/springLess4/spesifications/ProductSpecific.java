package com.spring.grebenyuk.market.springLess4.spesifications;

import com.spring.grebenyuk.market.springLess4.entities.Product;
import org.springframework.data.jpa.domain.Specification;

public class ProductSpecific {

    public static Specification<Product> priceGreaterOrEqualsThan(int min){
        return (Specification<Product>) (root, criteriaQuery, criteriaBuilder) ->
                criteriaBuilder.greaterThanOrEqualTo(root.get("price"), min);
    }
    public static Specification<Product> priceLessOrEqualsThan(int max){
        return (Specification<Product>) (root, criteriaQuery, criteriaBuilder) ->
                criteriaBuilder.lessThanOrEqualTo(root.get("price"), max);
    }
    public static Specification<Product> titleLike(String title){
        return (Specification<Product>) (root, criteriaQuery, criteriaBuilder) ->
                criteriaBuilder.like(root.get("title"), String.format("%%%s%%", title));
    }

}
