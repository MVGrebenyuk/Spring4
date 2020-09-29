package com.spring.grebenyuk.market.springLess4.repositories;

import com.spring.grebenyuk.market.springLess4.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
