package com.example.velocerentals.domain.enums;

import java.util.Arrays;
import java.util.Objects;

public enum PayMethods {

    CASH("cash"),
    CREDIT_CARD("credit_card"),
    DEBIT_CARD("debit_card"),
    BANK_TRANSFER("bank_transfer"),
    ;

    private final String value;

    PayMethods(String value) {
        this.value = value;
    }

    /**
 * Este método se utiliza para recuperar un enumerado PayMethods basado en el valor proporcionado.
 * @param value El valor para coincidir con el valor del enumerado.
 * @return El enumerado PayMethods que coincide con el valor proporcionado.
 * @throws IllegalArgumentException Si no hay ningún enumerado que coincida con el valor proporcionado.
 */
public static PayMethods getPayMethods(String value) {
    return Arrays.stream(PayMethods.values())
          .filter(e -> Objects.equals(e.value, value))
          .findFirst()
          .orElseThrow();
}
}
