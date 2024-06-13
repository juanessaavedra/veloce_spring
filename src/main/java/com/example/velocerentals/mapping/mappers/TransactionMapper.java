package com.example.velocerentals.mapping.mappers;


import com.example.velocerentals.domain.entities.Transaction;
import com.example.velocerentals.mapping.dtos.TransactionDTO;

public class TransactionMapper {

    public static Transaction mapFromModel(TransactionDTO transactionDTO) {
        return Transaction.builder()
                .id(transactionDTO.id())
                .reservation(transactionDTO.reservation())
                .totalAmount(transactionDTO.totalAmount())
                .dateTime(transactionDTO.dateTime())
                .payMethods(transactionDTO.payMethods())
                .status(transactionDTO.status())
                .build();

    }

    public static TransactionDTO mapFromDto(Transaction transaction) {
        return TransactionDTO.builder()
                .id(transaction.getId())
                .reservation(transaction.getReservation())
                .totalAmount(transaction.getTotalAmount())
                .dateTime(transaction.getDateTime())
                .payMethods(transaction.getPayMethods())
                .status(transaction.getStatus())
                .build();
    }
}
