package com.example.velocerentals.repositories.vehicles;

import com.example.velocerentals.domain.model.Vehicle;


import java.util.List;

public interface VehicleRepository {

    List<Vehicle> listVehicles();

    Vehicle byIdVehicle(Long id);

    void removeVehicle(Long id);

    void addVehicle(Vehicle vehicle);



}
