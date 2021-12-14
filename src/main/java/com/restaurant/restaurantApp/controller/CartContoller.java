package com.restaurant.restaurantApp.controller;

import com.restaurant.restaurantApp.entity.Cart;
import com.restaurant.restaurantApp.entity.User;
import com.restaurant.restaurantApp.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/CartV1")
@CrossOrigin
@RequiredArgsConstructor
public class CartContoller {

    @Autowired
    private CartService cartService;

    @PostMapping("/cart/save")
    public ResponseEntity<Cart> saveProduct(@RequestBody Cart cart){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("controller/cart/save").toUriString());
        return ResponseEntity.created(uri).body(cartService.saveProduct(cart));
    }

    @GetMapping(path = "/cart/user/{username}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Cart>> searchUser(@PathVariable String username) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("controller/cart/user/{username}").toUriString());
        return ResponseEntity.created(uri).body(cartService.findByUsername(username));
    }

}
