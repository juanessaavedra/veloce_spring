package com.example.velocerentals.services.vehicles;

import com.example.velocerentals.domain.model.Vehicle;
import com.example.velocerentals.mapping.dtos.VehicleDTO;
import com.example.velocerentals.mapping.mappers.VehicleMapper;

import com.example.velocerentals.repositories.vehicles.VehicleRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    private VehicleRepositoryImpl vehicleRepository;
    @Override
    public List<VehicleDTO> listVehicles() {
        return vehicleRepository.listVehicles().stream().map(VehicleMapper::mapFrom).toList();
    }

    @Override
    public VehicleDTO byIdVehicle(Long id) {
        Vehicle vehicle = vehicleRepository.byIdVehicle(id);
        return VehicleMapper.mapFrom(vehicle);
    }

    @Override
    public void removeVehicle(Long id) {
        vehicleRepository.removeVehicle(id);
    }

    @Override
    public void addVehicle(VehicleDTO vehicleDTO) {
        vehicleRepository.addVehicle(VehicleMapper.mapFrom(vehicleDTO));
    }
}
