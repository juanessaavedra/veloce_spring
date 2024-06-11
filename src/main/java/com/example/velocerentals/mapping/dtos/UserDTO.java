package com.example.velocerentals.mapping.dtos;

import lombok.Builder;

@Builder
public record UserDTO(Long id, String name, int age, String email, String cellphone) {
}
