package com.example.velocerentals.controllers;


import com.example.velocerentals.mapping.dtos.VehicleDTO;
import com.example.velocerentals.services.vehicles.VehicleService;
import jakarta.validation.Valid;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/vehicles")
public class VehicleController {


    @Autowired
    private VehicleService vehicleService;

    /** Obtiene una lista de todos los vehículos.**/
    @GetMapping(value = "/get-vehicles")
    public List<VehicleDTO> getVehicles() {return vehicleService.listVehicles();}

    /** Obtiene un vehículo por su identificador.**/
    @GetMapping(value = "/get-vehicles-id/{id}")
    public VehicleDTO byIdVehicle(@PathVariable Long id) throws BadRequestException {return vehicleService.byIdVehicle(id);}

    /** Elimina un vehículo por su identificador.**/
    @DeleteMapping(value = "/delete-vehicles-id/{id}")
    public void removeVehicle(@PathVariable Long id) {vehicleService.removeVehicle(id);}

    /** Añade un nuevo vehículo.**/
    @PostMapping(value = "/add-vehicle")
    public void addVehicle(@RequestBody @Valid VehicleDTO vehicleDTO) {vehicleService.addVehicle(vehicleDTO);}

}