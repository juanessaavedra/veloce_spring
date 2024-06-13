package com.example.velocerentals.mapping.dtos;

import jakarta.validation.constraints.*;
import lombok.Builder;

@Builder
public record UserDTO(Long id,

                      @NotNull(message = "Name cannot be null")
                              @NotEmpty(message = "Name cannot be empty")
                              @NotBlank(message = "Name cannot be blank")

                      String name,
                      @PositiveOrZero(message = "Age cannot be negative")
                      int age,

                      @Email(message = "Invalid email")
                      String email,

                      @Size(max = 10)
                      String cellphone) {
}
