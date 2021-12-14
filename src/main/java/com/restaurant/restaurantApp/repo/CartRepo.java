package com.restaurant.restaurantApp.repo;

import com.restaurant.restaurantApp.entity.Cart;
import com.restaurant.restaurantApp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepo extends JpaRepository<Cart, Long> {
    Cart findFirstByUsername(String username);

}
