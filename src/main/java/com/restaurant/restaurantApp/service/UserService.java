package com.restaurant.restaurantApp.service;

import com.restaurant.restaurantApp.dto.UserDTO;
import com.restaurant.restaurantApp.entity.Role;
import com.restaurant.restaurantApp.entity.User;

import java.util.ArrayList;
import java.util.List;

public interface UserService {
    User saveUser(User user);
    Role saveRole(Role role);
    void addRoleToUser(String username, String roleName);
    User getUser(String username);
    List<User>getUsers();
    void registerUser(UserDTO dto);
    UserDTO searchUser(String username);
}
