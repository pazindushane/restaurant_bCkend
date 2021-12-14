package com.restaurant.restaurantApp.service;

import com.restaurant.restaurantApp.dto.UserDTO;
import com.restaurant.restaurantApp.entity.Role;
import com.restaurant.restaurantApp.entity.User;
import com.restaurant.restaurantApp.exception.ValidateException;
import com.restaurant.restaurantApp.repo.RoleRepo;
import com.restaurant.restaurantApp.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@Slf4j
public class UserServiceImpl implements UserService, UserDetailsService {

    @Autowired
    private  UserRepo userRepo;
    @Autowired
    private  RoleRepo roleRepo;
    @Autowired
    private  PasswordEncoder passwordEncoder;

    @Autowired
    private ModelMapper mapper;

    @Override
    public User saveUser(User user) {
        log.info("saving new user {} to the database", user.getName());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepo.save(user);
    }

    @Override
    public Role saveRole(Role role) {
        log.info("saving new role {} to the database", role.getName());
        return roleRepo.save(role);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        log.info("Adding role {} to user {}", roleName, username);
        User user = userRepo.findByUsername(username);
        Role role = roleRepo.findByName(roleName);
        user.getRoles().add(role);
    }

    @Override
    public User getUser(String username) {
        log.info("Fetching user {}", username);
        return userRepo.findByUsername(username);
    }

    @Override
    public List<User> getUsers() {
        log.info("Fetching all users");
        return userRepo.findAll();
    }


    @Override
    public void registerUser(UserDTO dto) {
        userRepo.save(mapper.map(dto, User.class));
    }

    @Override
    public UserDTO searchUser(String username) {
        Optional<User> user = Optional.ofNullable(userRepo.findByUsername(username));
        if (user.isPresent()) {
            return mapper.map(user.get(), UserDTO.class);
        }else {
            throw new ValidateException("No User for This Email..!");
        }
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByUsername(username);
        if (user == null) {
            log.error("USer not found in the database");
            throw new UsernameNotFoundException("user Not found in the database");
        }else {
            log.info("User Found in the database: {}", username);
        }
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        user.getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        });
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities);
    }
}
