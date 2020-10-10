package com.spring.grebenyuk.market.springLess4.services;

import com.spring.grebenyuk.market.springLess4.entities.Cart;
import com.spring.grebenyuk.market.springLess4.entities.Product;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CartService {

    List<Product> products;

    private Cart cart;

    public void addProduct(Product prod){
       cart.addProd(prod);
    }

    public List<Product> showProducts(){
        return cart.getProdList();
    }

    @Autowired
    public void setCart(Cart cart) {
        this.cart = cart;
    }
}
