package com.example.velocerentals.controllers;

import com.example.velocerentals.mapping.dtos.UserDTO;
import com.example.velocerentals.services.users.UserService;
import jakarta.validation.Valid;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * Obtiene una lista de todos los usuarios.
     */
    @GetMapping(value = "/get-users")
    public List<UserDTO> getUsers() {return userService.listUsers();}

    /**
     * Busca un usuario por su identificador.
     */
    @GetMapping(value = "/get-users-id/{id}")
    public UserDTO byIdUser(@PathVariable Long id) throws BadRequestException {return userService.byIdUser(id);}

    /**
     * Busca un usuario por su correo electrónico.
     */
    @GetMapping(value = "/get-users-email/{email}")
    public Optional<UserDTO> byEmailUser(@PathVariable String email) throws BadRequestException {return userService.byEmailUser(email);}

    @GetMapping(value = "/get-users-password/{password}")
    public Optional<UserDTO> byPassword(@PathVariable String password) throws BadRequestException {return userService.byPassword(password);}

    /**
     * Elimina un usuario por su identificador.
     */
    @DeleteMapping(value = "/delete-user/{id}")
    public void removeUser(@PathVariable Long id) {userService.removeUser(id);}

    /**
     * Agrega un nuevo usuario.
     */
    @PostMapping(value = "/create-user")
    public void addUser(@RequestBody @Valid UserDTO userDTO) {userService.addUser(userDTO);}
}

