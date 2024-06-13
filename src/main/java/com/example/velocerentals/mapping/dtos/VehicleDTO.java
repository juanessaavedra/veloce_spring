package com.example.velocerentals.mapping.dtos;


import com.example.velocerentals.domain.enums.VehicleAvailable;
import com.example.velocerentals.domain.enums.VehicleCategory;

import jakarta.validation.constraints.*;
import lombok.Builder;

@Builder
public record VehicleDTO(Long id,
                         @NotBlank(message = "Name cannot be blank")
                                 @NotEmpty (message = "Name cannot be empty")
                                 @NotNull (message = "Name cannot be null")
                         String name,
                         @PositiveOrZero(message = "Price cannot be negative")
                         double price,
                         @NotNull (message = "Category cannot be null")
                                 @NotEmpty (message = "Category cannot be empty")
                                 @NotBlank (message = "Category cannot be blank")
                         VehicleCategory category,
                         @NotEmpty (message = "Available cannot be empty")
                                 @NotBlank (message = "Available cannot be blank")
                                 @NotNull (message = "Available cannot be null")
                         VehicleAvailable available,

                         @Size(max = 7)
                         String plate) {
}