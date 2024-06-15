package com.example.velocerentals.services.vehicles;


import com.example.velocerentals.domain.entities.Vehicle;
import com.example.velocerentals.domain.enums.VehicleAvailable;
import com.example.velocerentals.domain.enums.VehicleCategory;
import com.example.velocerentals.mapping.dtos.VehicleDTO;
import org.apache.coyote.BadRequestException;

import java.util.List;
import java.util.Optional;

public interface VehicleService {

    List<VehicleDTO> listVehicles();

    VehicleDTO byIdVehicle(Long id) throws BadRequestException;

    void removeVehicle(Long id);

    VehicleDTO saveVehicle(VehicleDTO vehicleDTO);

    Optional<VehicleDTO> findByPrice(double price);

    List<VehicleDTO> listByCategory(VehicleCategory category);

    List<VehicleDTO> listByAvailability(VehicleAvailable available);




}
