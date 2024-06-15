package com.example.velocerentals.domain.enums;

import java.util.Arrays;
import java.util.Objects;

public enum VehicleAvailable {

    AVAILABLE("Available"),
    UNAVAILABLE("Unavailable"),

    RENTED("Rented");


    private final String value;

    VehicleAvailable(String value) {
        this.value = value;
    }



public static VehicleAvailable getAvailability(String value) {
    return Arrays.stream(VehicleAvailable.values())
           .filter(e -> Objects.equals(e.value, value))
           .findFirst()
           .orElseThrow();
}
}
