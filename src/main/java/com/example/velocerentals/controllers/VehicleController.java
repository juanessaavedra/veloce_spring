package com.example.velocerentals.controllers;


import com.example.velocerentals.mapping.dtos.VehicleDTO;
import com.example.velocerentals.services.vehicles.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/vehicles")
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    @GetMapping(value = "/get-vehicles")
    public List<VehicleDTO> getVehicles() {return vehicleService.listVehicles();}

    @GetMapping(value = "/get-vehicles/{id}")
    public VehicleDTO byIdVehicle(@PathVariable Long id) {return vehicleService.byIdVehicle(id);}

    @DeleteMapping(value = "/delete-vehicles/{id}")
    public void removeVehicle(@PathVariable Long id) {vehicleService.removeVehicle(id);}

    @PostMapping(value = "/add-vehicles")
    public void addVehicle(@RequestBody VehicleDTO vehicleDTO) {vehicleService.addVehicle(vehicleDTO);}

}
