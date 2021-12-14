package com.restaurant.restaurantApp.dto;

import com.restaurant.restaurantApp.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartDTO {
    private Long id;
    private String username;
    private String foodName;
    private String foodSize;
    private int foodCount;
    private String foodName1;
    private int foodCount1;
    private String foodName2;
    private int foodCount2;
}
