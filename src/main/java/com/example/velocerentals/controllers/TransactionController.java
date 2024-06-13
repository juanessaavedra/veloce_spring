package com.example.velocerentals.controllers;



import com.example.velocerentals.mapping.dtos.TransactionDTO;
import com.example.velocerentals.services.transactions.TransactionService;
import jakarta.validation.Valid;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping(value = "/transactions")
public class TransactionController {


    @Autowired
    private TransactionService transactionService;

    /**
     * Obtiene una lista de todas las transacciones.
     */
    @GetMapping(value = "/get-transactions")
    public List<TransactionDTO> getTransactions() {
        return transactionService.listTransactions();
    }

    /**
     * Obtiene una transacción por su identificador.
     */
    @GetMapping(value = "/get-transactions-id/{id}")
    public TransactionDTO byIdTransaction(@PathVariable Long id) throws BadRequestException {
        return transactionService.byIdTransaction(id);
    }

    /**
     * Obtiene una transacción por el identificador de reserva.
     */
    @GetMapping(value = "/get-transactions-idreservation/{idReservation}")
    public Optional<TransactionDTO> byIdReservation(@PathVariable Long idReservation) throws BadRequestException {
        return transactionService.findByReservationId(idReservation);
    }

    /**
     * Elimina una transacción por su identificador.
     */
    @DeleteMapping(value = "/delete-transaction/{id}")
    public void removeTransaction(@PathVariable Long id) {
        transactionService.removeTransaction(id);
    }

    /**
     * Crea una nueva transacción.
     */
    @PostMapping(value = "/create-transaction")
    public void createTransaction(@RequestBody @Valid TransactionDTO transactionDTO) {
        transactionService.addTransaction(transactionDTO);
    }
}