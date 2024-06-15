package com.example.velocerentals.repositories.vehicles;


import com.example.velocerentals.domain.entities.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

    Optional<Vehicle> findByPrice(double price);

}
