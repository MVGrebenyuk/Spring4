package com.spring.grebenyuk.market.springLess4.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "products")
@Data
@NoArgsConstructor
public class Product implements Comparable<Product>{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @OneToMany(mappedBy = "product")
    @JsonIgnore
    private List<Order> orders;

    @Column(name = "price")
    private int price;

    public int getPrice() {
        return price;
    }

    @Override
    public int compareTo(Product o) {
        int comparePrice = o.getPrice();
        return this.price - comparePrice;
    }
}
