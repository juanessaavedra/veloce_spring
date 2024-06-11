package com.example.velocerentals.repositories.vehicles;

import com.example.velocerentals.domain.model.Vehicle;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional

public class VehicleRepositoryImpl implements VehicleRepository{

    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<Vehicle> listVehicles() {
        String query = "FROM Vehicle";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public Vehicle byIdVehicle(Long id) {
        Vehicle vehicle = entityManager.find(Vehicle.class, id);
        return vehicle;
    }

    @Override
    public void removeVehicle(Long id) {
        Vehicle vehicle = entityManager.find(Vehicle.class, id);
        entityManager.remove(vehicle);
    }

    @Override
    public void addVehicle(Vehicle vehicle) {
        entityManager.merge(vehicle);
    }
}
