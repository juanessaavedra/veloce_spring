package com.example.velocerentals.mapping.mappers;


import com.example.velocerentals.domain.model.User;
import com.example.velocerentals.mapping.dtos.UserDTO;


public class UserMapper {
    public static User mapFrom(UserDTO userProfileDTO) {
        return User.builder()
                .id(userProfileDTO.id())
                .name(userProfileDTO.name())
                .age(userProfileDTO.age())
                .email(userProfileDTO.email())
                .cellphone(userProfileDTO.cellphone())
                .build();

    }

    public static UserDTO mapFrom(User userProfile) {
        return UserDTO.builder()
                .id(userProfile.getId())
                .name(userProfile.getName())
                .age(userProfile.getAge())
                .email(userProfile.getEmail())
                .cellphone(userProfile.getCellphone())
                .build();
    }
}

