package com.example.velocerentals.services.users;

import com.example.velocerentals.domain.model.User;
import com.example.velocerentals.mapping.dtos.UserDTO;
import com.example.velocerentals.mapping.mappers.UserMapper;
import com.example.velocerentals.repositories.users.UserRepository;

import com.example.velocerentals.repositories.users.UserRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepositoryImpl userRepository;

    @Override
    public List<UserDTO> listUsers() {
        return userRepository.listUsers().stream().map(UserMapper::mapFrom).toList();
    }

    @Override
    public UserDTO byIdUser(Long id) {
        User user = userRepository.byIdUser(id);
        return UserMapper.mapFrom(user);
    }

    @Override
    public void removeUser(Long id) {
        userRepository.removeUser(id);
    }

    @Override
    public void addUser(UserDTO userDTO) {
        userRepository.addUser(UserMapper.mapFrom(userDTO));
    }
}
