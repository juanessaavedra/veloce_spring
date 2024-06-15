package com.example.velocerentals.mapping.mappers;


import com.example.velocerentals.domain.entities.User;
import com.example.velocerentals.mapping.dtos.UserDTO;


public class UserMapper {
    public static User mapFromModel(UserDTO userProfileDTO) {
        return User.builder()
                .id(userProfileDTO.id())
                .name(userProfileDTO.name())
                .age(userProfileDTO.age())
                .email(userProfileDTO.email())
                .cellphone(userProfileDTO.cellphone())
                .password(userProfileDTO.password())
                .build();

    }

    public static UserDTO mapFromDto(User user) {
        return UserDTO.builder()
                .id(user.getId())
                .name(user.getName())
                .age(user.getAge())
                .email(user.getEmail())
                .cellphone(user.getCellphone())
                .password(user.getPassword())
                .build();
    }
}

