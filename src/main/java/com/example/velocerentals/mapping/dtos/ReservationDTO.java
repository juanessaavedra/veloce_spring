package com.example.velocerentals.mapping.dtos;

import com.example.velocerentals.domain.entities.User;
import com.example.velocerentals.domain.entities.Vehicle;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Builder;

import java.time.LocalDate;


@Builder
public record ReservationDTO(Long id,

                             @NotNull(message = "Vehicle cannot be null")
                             Vehicle vehicle,

                             @NotNull(message = "User cannot be null")
                             User user,

                             LocalDate startDate,
                             LocalDate endDate,

                             @PositiveOrZero(message = "Total price must be zero or positive")
                             double totalPrice,

                             int status)
                              {
}
