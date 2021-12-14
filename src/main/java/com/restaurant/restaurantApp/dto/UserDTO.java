package com.restaurant.restaurantApp.dto;

import com.restaurant.restaurantApp.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collection;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private Long id;
    private String name;
    private String username;
    private String password;
    private String email;
    private String contact;
    private Collection<Role> roles = new ArrayList<>();
}
