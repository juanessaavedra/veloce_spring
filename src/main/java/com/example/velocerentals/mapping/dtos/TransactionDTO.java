package com.example.velocerentals.mapping.dtos;

import com.example.velocerentals.domain.enums.PayMethods;
import com.example.velocerentals.domain.entities.Reservation;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Builder;

import java.time.LocalDateTime;


@Builder
public record TransactionDTO(Long id,

                             @NotNull(message = "Reservation cannot be null")
                                     @NotEmpty(message = "Reservation cannot be empty")
                                     @NotBlank(message = "Reservation cannot be blank")
                             Reservation reservation,

                             @PositiveOrZero(message = "Total amount must be positive or zero")
                             double totalAmount,

                             LocalDateTime dateTime,

                             @NotNull (message = "Paymethods cannot be null")
                                     @NotEmpty  (message = "Paymethods cannot be empty")
                                     @NotBlank  (message = "Paymethods cannot be blank")
                             PayMethods payMethods,

                             int status

                             ) {
}
