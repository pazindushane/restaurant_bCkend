package com.restaurant.restaurantApp.repo;

import com.restaurant.restaurantApp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
