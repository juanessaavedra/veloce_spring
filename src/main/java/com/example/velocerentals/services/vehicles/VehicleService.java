package com.example.velocerentals.services.vehicles;

import com.example.velocerentals.domain.model.User;
import com.example.velocerentals.mapping.dtos.VehicleDTO;

import java.util.List;

public interface VehicleService {

    List<VehicleDTO> listVehicles();

    VehicleDTO byIdVehicle(Long id);

    void removeVehicle(Long id);

    void addVehicle(VehicleDTO vehicleDTO);
}
