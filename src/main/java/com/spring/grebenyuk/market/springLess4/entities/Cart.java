package com.spring.grebenyuk.market.springLess4.entities;

import com.sun.deploy.security.ValidationState;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

@Component
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
@AllArgsConstructor
public class Cart {

    private List<Product> prodList;

    public List<Product> getProdList() {
        return prodList;
    }

    public void setProdList(List<Product> prodList) {
        this.prodList = prodList;
    }

    public void addProd(Product prod){
        prodList.add(prod);
    }

}
