package com.restaurant.restaurantApp.service;

import com.restaurant.restaurantApp.dto.CartDTO;
import com.restaurant.restaurantApp.entity.Cart;
import com.restaurant.restaurantApp.entity.User;

import java.util.List;

public interface CartService {
    Cart saveProduct(Cart cart);
    List<Cart> findByUsername(String username);
}
