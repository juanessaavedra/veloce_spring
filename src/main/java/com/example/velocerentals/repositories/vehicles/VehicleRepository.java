package com.example.velocerentals.repositories.vehicles;

import com.example.velocerentals.domain.entities.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;



public interface VehicleRepository extends JpaRepository<Vehicle, Long> {


}
