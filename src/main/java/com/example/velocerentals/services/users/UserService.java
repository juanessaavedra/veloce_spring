package com.example.velocerentals.services.users;

import com.example.velocerentals.domain.model.User;
import com.example.velocerentals.mapping.dtos.UserDTO;

import java.util.List;

public interface UserService {


    List<UserDTO> listUsers();

    UserDTO byIdUser(Long id);

    void removeUser(Long id);

    void addUser(UserDTO userDTO);
}
