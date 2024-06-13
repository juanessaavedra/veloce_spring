package com.example.velocerentals.services.vehicles;

import com.example.velocerentals.mapping.dtos.VehicleDTO;
import com.example.velocerentals.mapping.mappers.VehicleMapper;
import com.example.velocerentals.repositories.vehicles.VehicleRepository;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;



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
 * Añade un nuevo vehículo a la base de datos.
 */
@Override
public VehicleDTO addVehicle(VehicleDTO vehicleDTO) {
    return VehicleMapper.mapFromDto(vehicleRepository.save(VehicleMapper.mapFromModel(vehicleDTO)));
}
}
