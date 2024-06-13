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


    /**
 * Este método se utiliza para obtener el estado de disponibilidad de un vehículo basado en un valor de cadena.
 * Recibe un parámetro de cadena que representa el estado de disponibilidad.
 * Devuelve un enumerado de VehicleAvailable que coincide con el valor de entrada.
 * Si no se encuentra ningún valor coincidente, se lanza una excepción.
 */
public static VehicleAvailable getAvailability(String value) {
    return Arrays.stream(VehicleAvailable.values())
           .filter(e -> Objects.equals(e.value, value))
           .findFirst()
           .orElseThrow();
}
}
