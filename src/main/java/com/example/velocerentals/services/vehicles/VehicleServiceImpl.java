package com.example.velocerentals.services.vehicles;

import com.example.velocerentals.domain.entities.Vehicle;
import com.example.velocerentals.domain.enums.VehicleAvailable;
import com.example.velocerentals.domain.enums.VehicleCategory;
import com.example.velocerentals.mapping.dtos.VehicleDTO;
import com.example.velocerentals.mapping.mappers.VehicleMapper;
import com.example.velocerentals.repositories.vehicles.VehicleRepository;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;


/**
 * Obtiene una lista de todos los vehículos almacenados en la base de datos.
 */
@Override
public List<VehicleDTO> listVehicles() {
    return vehicleRepository.findAll().stream().map(VehicleMapper::mapFromDto).toList();
}

/**
 * Busca un vehículo por su identificador único.
 */
@Override
public VehicleDTO byIdVehicle(Long id) throws BadRequestException {
    return VehicleMapper.mapFromDto(vehicleRepository.findById(id).orElseThrow(()-> new BadRequestException("Vehículo no encontrado")));
}

/**
 * Elimina un vehículo de la base de datos por su identificador único.
 */
@Override
public void removeVehicle(Long id) {
    vehicleRepository.deleteById(id);
}

/**
 * Añade o actualiza vehículo a la base de datos.
 */
@Override
public VehicleDTO saveVehicle(VehicleDTO vehicleDTO) {
    return VehicleMapper.mapFromDto(vehicleRepository.save(VehicleMapper.mapFromModel(vehicleDTO)));
}

    /**
 * Busca un vehículo por su precio.
 */
@Override
public Optional<VehicleDTO> findByPrice(double price) {
    Optional<VehicleDTO> userDTO = vehicleRepository.findByPrice(price).map(VehicleMapper::mapFromDto);
    if(userDTO.isEmpty()){
        return Optional.empty();
    }
    return userDTO;
}

/**
 * Lista todos los vehículos por categoría.
 */
@Override
public List<VehicleDTO> listByCategory(VehicleCategory category) {
    List<VehicleDTO> vehicles = new ArrayList<>();
    for(Vehicle vehicle : vehicleRepository.findAll()){
        if(vehicle.getCategory().equals(category)){
            vehicles.add(VehicleMapper.mapFromDto(vehicle));
        }
    }
    return vehicles;
}

/**
 * Lista todos los vehículos por disponibilidad.
 */
@Override
public List<VehicleDTO> listByAvailability(VehicleAvailable available) {
    List<VehicleDTO> vehicles = new ArrayList<>();
    for(Vehicle vehicle : vehicleRepository.findAll()){
        if(vehicle.getAvailable().equals(available)){
            vehicles.add(VehicleMapper.mapFromDto(vehicle));
        }
    }
    return vehicles;
}
    }
