package com.example.velocerentals.domain.enums;

import java.util.Arrays;
import java.util.Objects;

public enum VehicleCategory {

    CAR("CAR"),
    MOTORCYCLE("MOTORCYCLE"),
    TRUCK("TRUCK"),
    VAN("VAN");


    private final String value;

    VehicleCategory(String value) {
        this.value = value;
    }


public static VehicleCategory getVehicleCategory(String value) {
    return Arrays.stream(VehicleCategory.values())
           .filter(e -> Objects.equals(e.value, value))
           .findFirst()
           .orElseThrow(() -> new IllegalArgumentException("No se encontró la categoría de vehículo con el valor: " + value));
}
}
