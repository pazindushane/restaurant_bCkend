package com.restaurant.restaurantApp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.GenerationType.AUTO;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cart {
    @Id
    @GeneratedValue(strategy = AUTO)
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
