package com.example.velocerentals.services.vehicles;


import com.example.velocerentals.mapping.dtos.VehicleDTO;
import org.apache.coyote.BadRequestException;

import java.util.List;

public interface VehicleService {

    List<VehicleDTO> listVehicles();

    VehicleDTO byIdVehicle(Long id) throws BadRequestException;

    void removeVehicle(Long id);

    VehicleDTO addVehicle(VehicleDTO vehicleDTO);
}
