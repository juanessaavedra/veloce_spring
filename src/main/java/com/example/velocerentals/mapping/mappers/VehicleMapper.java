package com.example.velocerentals.mapping.mappers;


import com.example.velocerentals.domain.model.Vehicle;
import com.example.velocerentals.mapping.dtos.VehicleDTO;


public class VehicleMapper {
    public static Vehicle mapFrom(VehicleDTO vehicleDTO) {
        return Vehicle.builder()
                .id(vehicleDTO.id())
                .name(vehicleDTO.name())
                .price(vehicleDTO.price())
                .category(vehicleDTO.category())
                .disponibility(vehicleDTO.disponility())
                .plate(vehicleDTO.plate())
                .build();

    }

    public static VehicleDTO mapFrom(Vehicle vehicle) {
        return VehicleDTO.builder()
                .id(vehicle.getId())
                .name(vehicle.getName())
                .price(vehicle.getPrice())
                .category(vehicle.getCategory())
                .disponility(vehicle.getDisponibility())
                .plate(vehicle.getPlate())
                .build();
    }
}

