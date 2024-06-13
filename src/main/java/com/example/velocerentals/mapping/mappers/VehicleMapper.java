package com.example.velocerentals.mapping.mappers;


import com.example.velocerentals.domain.entities.Vehicle;
import com.example.velocerentals.mapping.dtos.VehicleDTO;


public class VehicleMapper {
    public static Vehicle mapFromModel(VehicleDTO vehicleDTO) {
        return Vehicle.builder()
                .id(vehicleDTO.id())
                .name(vehicleDTO.name())
                .price(vehicleDTO.price())
                .category(vehicleDTO.category())
                .available(vehicleDTO.available())
                .plate(vehicleDTO.plate())
                .build();

    }

    public static VehicleDTO mapFromDto(Vehicle vehicle) {
        return VehicleDTO.builder()
                .id(vehicle.getId())
                .name(vehicle.getName())
                .price(vehicle.getPrice())
                .category(vehicle.getCategory())
                .available(vehicle.getAvailable())
                .plate(vehicle.getPlate())
                .build();
    }
}

