package com.example.velocerentals.mapping.dtos;


import lombok.Builder;

@Builder
public record VehicleDTO(Long id, String name, double price, String category, String disponility, String plate) {
}