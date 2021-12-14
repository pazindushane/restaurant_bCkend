package com.restaurant.restaurantApp;

import com.restaurant.restaurantApp.entity.Role;
import com.restaurant.restaurantApp.entity.User;
import com.restaurant.restaurantApp.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class RestaurantAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestaurantAppApplication.class, args);
	}

	@Bean
	PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	@Bean
	CommandLineRunner run(UserService userService){
		return args -> {
			userService.saveRole(new Role(null,"ROLE_USER"));
			userService.saveRole(new Role(null,"ROLE_MANAGER"));
			userService.saveRole(new Role(null,"ROLE_ADMIN"));
			userService.saveRole(new Role(null,"ROLE_SUPER_ADMIN"));

			userService.saveUser(new User(null, "Jhon trevelta", "Jhon", "1234","Jhon@Gmail.com","077123456", new ArrayList<>()));
			userService.saveUser(new User(null, "Will Smith", "Will", "5678","Will@Gmail.com","0771234546", new ArrayList<>()));
			userService.saveUser(new User(null, "Pasindu Dilmin", "Pasindu", "1483","Pasindu@Gmail.com","0771567546", new ArrayList<>()));
			userService.saveUser(new User(null, "Udra san", "Udara", "9101","Udra@Gmail.com","0770977546", new ArrayList<>()));

			userService.addRoleToUser("Jhon", "ROLE_USER");
			userService.addRoleToUser("Jhon", "ROLE_MANAGER");
			userService.addRoleToUser("Will", "ROLE_MANAGER");
			userService.addRoleToUser("Pasindu", "ROLE_ADMIN");
			userService.addRoleToUser("Udara", "ROLE_SUPER_ADMIN");
			userService.addRoleToUser("Udara", "ROLE_ADMIN");
			userService.addRoleToUser("Udara", "ROLE_MANAGER");
			userService.addRoleToUser("Udara", "ROLE_USER");
		};
	}

}
