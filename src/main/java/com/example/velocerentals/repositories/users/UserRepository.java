package com.example.velocerentals.repositories.users;

import com.example.velocerentals.domain.model.User;

import java.util.List;

public interface UserRepository {

    List<User> listUsers();

    User byIdUser(Long id);

    void removeUser(Long id);

    void addUser(User user);

}
