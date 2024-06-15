package com.example.velocerentals.services.users;

import com.example.velocerentals.mapping.dtos.UserDTO;
import com.example.velocerentals.mapping.mappers.UserMapper;

import com.example.velocerentals.repositories.users.UserRepository;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;


/**
 * Obtiene una lista de todos los usuarios.
 */
@Override
public List<UserDTO> listUsers() {
    return userRepository.findAll().stream().map(UserMapper::mapFromDto).toList();
}

/**
 * Busca un usuario por su identificador.
 */
@Override
public UserDTO byIdUser(Long id) throws BadRequestException {
    return UserMapper.mapFromDto(userRepository.findById(id).orElseThrow(() -> new BadRequestException("Usuario no encontrado")));
}

/**
 * Elimina un usuario por su identificador.
 */
@Override
public void removeUser(Long id) {
    userRepository.deleteById(id);
}

/**
 * Añade o actualiza un usuario.
 */
@Override
public UserDTO saveUser(UserDTO userDTO) {
    return UserMapper.mapFromDto(userRepository.save(UserMapper.mapFromModel(userDTO)));
}


    /**
 * Busca un usuario por su correo electrónico.
 */
@Override
public Optional<UserDTO> byEmailUser(String email)  {
    Optional<UserDTO> userDTO = userRepository.findByEmail(email).map(UserMapper::mapFromDto);
    if(userDTO.isEmpty()){
        return Optional.empty();
    }
    return userDTO;
}

   /**
 * Busca un usuario por su contraseña.
 */
@Override
public Optional<UserDTO> byPassword(String password) throws BadRequestException {
    Optional<UserDTO> userDTO = userRepository.findByPassword(password).map(UserMapper::mapFromDto);
    if(userDTO.isEmpty()){
        return Optional.empty();
    }
    return userDTO;
}

}
