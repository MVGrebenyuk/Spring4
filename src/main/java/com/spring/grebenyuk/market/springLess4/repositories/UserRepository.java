package com.spring.grebenyuk.market.springLess4.repositories;

import com.spring.grebenyuk.market.springLess4.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    public User findByUsername(String username);

}
