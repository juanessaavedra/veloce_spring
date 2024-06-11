package com.example.velocerentals.controllers;


import com.example.velocerentals.domain.model.User;
import com.example.velocerentals.mapping.dtos.UserDTO;
import com.example.velocerentals.services.users.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/get-users")
    public List<UserDTO> getUsers() {return userService.listUsers();}

    @GetMapping(value = "/get-users/{id}")
    public UserDTO byIdUser(@PathVariable Long id) {return userService.byIdUser(id);}


    @DeleteMapping(value = "/delete-users/{id}")
    public void removeUser(@PathVariable Long id) {userService.removeUser(id);}

    @PostMapping(value = "/add-users")
    public void addUser(@RequestBody UserDTO userDTO) {userService.addUser(userDTO);}



}
