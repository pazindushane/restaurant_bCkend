package com.restaurant.restaurantApp.service.impl;

import com.restaurant.restaurantApp.dto.CartDTO;
import com.restaurant.restaurantApp.dto.UserDTO;
import com.restaurant.restaurantApp.entity.Cart;
import com.restaurant.restaurantApp.entity.User;
import com.restaurant.restaurantApp.exception.ValidateException;
import com.restaurant.restaurantApp.repo.CartRepo;
import com.restaurant.restaurantApp.service.CartService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CartServiceImpl implements CartService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private CartRepo cartRepo;


    @Override
    public Cart saveProduct(Cart cart) {
        return cartRepo.save(cart);
    }

    @Override
    public List<Cart> findByUsername(String username) {
        Optional<Cart> cart = Optional.ofNullable(cartRepo.findFirstByUsername(username));
        if (cart.isPresent()) {
            return cartRepo.findAll();
        }else {
            throw new ValidateException("No User");
        }
    }

}
