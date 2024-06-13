package com.example.velocerentals.services.transactions;


import com.example.velocerentals.mapping.dtos.TransactionDTO;
import org.apache.coyote.BadRequestException;

import java.util.List;
import java.util.Optional;

public interface TransactionService {


    List<TransactionDTO> listTransactions();

    TransactionDTO byIdTransaction(Long id) throws BadRequestException;

    void removeTransaction(Long id);

    TransactionDTO addTransaction(TransactionDTO transactionDTODTO);

    Optional<TransactionDTO> findByReservationId(Long idReservation);


}
