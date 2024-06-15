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


public static PayMethods getPayMethods(String value) {
    return Arrays.stream(PayMethods.values())
          .filter(e -> Objects.equals(e.value, value))
          .findFirst()
          .orElseThrow();
}
}
