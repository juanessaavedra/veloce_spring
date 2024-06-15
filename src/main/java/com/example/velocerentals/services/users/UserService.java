package com.example.velocerentals.services.users;


import com.example.velocerentals.mapping.dtos.UserDTO;
import org.apache.coyote.BadRequestException;

import java.util.List;
import java.util.Optional;

public interface UserService {


    List<UserDTO> listUsers();

    UserDTO byIdUser(Long id) throws BadRequestException;

    void removeUser(Long id);

    UserDTO addUser(UserDTO userDTO);

    Optional<UserDTO> byEmailUser(String email) throws BadRequestException;

    Optional<UserDTO> byPassword(String password) throws BadRequestException;


}
