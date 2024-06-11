package com.example.velocerentals.domain.model;


import com.example.velocerentals.domain.enums.VehicleCategory;
import com.example.velocerentals.domain.enums.VehicleDisponibility;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "vehicles")
@Entity

public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double price;

    @Enumerated
    private VehicleCategory category;

    @Enumerated
    private VehicleDisponibility disponibility;

    private String plate;

}
