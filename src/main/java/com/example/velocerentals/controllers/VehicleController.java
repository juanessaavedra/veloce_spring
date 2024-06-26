package com.example.velocerentals.controllers;


import com.example.velocerentals.domain.enums.VehicleAvailable;
import com.example.velocerentals.domain.enums.VehicleCategory;
import com.example.velocerentals.mapping.dtos.VehicleDTO;
import com.example.velocerentals.services.vehicles.VehicleService;
import jakarta.validation.Valid;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/vehicles")
public class VehicleController {


    @Autowired
    private VehicleService vehicleService;


    @GetMapping(value = "/get-vehicles")
    public List<VehicleDTO> getVehicles() {return vehicleService.listVehicles();}


    @GetMapping(value = "/get-vehicles-id/{id}")
    public VehicleDTO byIdVehicle(@PathVariable Long id) throws BadRequestException {return vehicleService.byIdVehicle(id);}

    @GetMapping(value = "/get-vehicles-price/{price}")
    public Optional<VehicleDTO> byPrice(@PathVariable double price) {return vehicleService.findByPrice(price);}


    @DeleteMapping(value = "/delete-vehicles-id/{id}")
    public void removeVehicle(@PathVariable Long id) {vehicleService.removeVehicle(id);}


    @PostMapping(value = "/add-vehicle")
    public void addVehicle(@RequestBody @Valid VehicleDTO vehicleDTO) {vehicleService.saveVehicle(vehicleDTO);}

    @GetMapping("/get-vehicles-category/{category}")
    public List<VehicleDTO> getVehiclesByCategory(@PathVariable VehicleCategory category) {
        return vehicleService.listByCategory(category);
    }

    @GetMapping("/get-vehicles-available/{available}")
    public List<VehicleDTO> getVehiclesByAvailable(@PathVariable VehicleAvailable available) {
        return vehicleService.listByAvailability(available);
    }

}