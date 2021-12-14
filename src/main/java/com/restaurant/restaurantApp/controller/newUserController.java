package com.restaurant.restaurantApp.controller;


import com.restaurant.restaurantApp.dto.UserDTO;
import com.restaurant.restaurantApp.service.UserService;
import com.restaurant.restaurantApp.util.StandardResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;

@RestController
@RequestMapping("/v1")
@CrossOrigin
@RequiredArgsConstructor
public class newUserController {


    private final UserService userService;


    @PostMapping(path = "/registerUser", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity saveUser(@RequestBody UserDTO dto) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("controller/user/registerUser").toUriString());
        userService.registerUser(dto);
        return new ResponseEntity(new StandardResponse("201", "Done", dto), HttpStatus.CREATED);
    }

//    @GetMapping(path = "/searchuser/{username}", produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity searchUserByName(@PathVariable String username) {
//        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("controller/searchuser/{username}").toUriString());
//        UserDTO userDTO =userService.searchUser(username);
//        return new ResponseEntity(new StandardResponse("200", "Done", userDTO), HttpStatus.OK);
//    }

//    @GetMapping(path = "/searchuser/{username}",produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity searchUserByName(@PathVariable String username) {
//        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("controller/searchuser/{username}").toUriString());
//        ArrayList<UserDTO> allDriverDetail = userService.getUserbyUname(username);
//        return new ResponseEntity(new StandardResponse("200", "Done", allDriverDetail), HttpStatus.OK);
//    }

    @GetMapping(path = "/{username}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity searchUser(@PathVariable String username) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("controller/{username}").toUriString());
//        UserDTO userDTO = userService.searchUser(username);
//        return new ResponseEntity(new StandardResponse("200", "Done", userDTO), HttpStatus.OK);
        return ResponseEntity.created(uri).body(userService.searchUser(username));
    }

}
