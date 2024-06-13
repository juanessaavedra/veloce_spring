package com.example.velocerentals.services.transactions;


import com.example.velocerentals.mapping.dtos.TransactionDTO;
import com.example.velocerentals.mapping.mappers.TransactionMapper;
import com.example.velocerentals.repositories.transaction.TransactionRepository;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionServiceImpl implements TransactionService{

    @Autowired
    private TransactionRepository transactionRepository;

    /**
 * Obtiene una lista de todas las transacciones almacenadas en la base de datos.
 */
@Override
public List<TransactionDTO> listTransactions() {
    return transactionRepository.findAll().stream().map(TransactionMapper::mapFromDto).toList();
}

/**
 * Busca y devuelve la transacción con el id especificado.
 */
@Override
public TransactionDTO byIdTransaction(Long id) throws BadRequestException {
    return TransactionMapper.mapFromDto(transactionRepository.findById(id).orElseThrow(() -> new BadRequestException("Transaction not found")));
}

/**
 * Elimina la transacción con el id especificado.
 */
@Override
public void removeTransaction(Long id) {
    transactionRepository.deleteById(id);
}

/**
 * Añade una nueva transacción a la base de datos.
 */
@Override
public TransactionDTO addTransaction(TransactionDTO transactionDTO) {
    return TransactionMapper.mapFromDto(transactionRepository.save(TransactionMapper.mapFromModel(transactionDTO)));
}

/**
 * Busca y devuelve la transacción asociada con la reserva con el id especificado.
 */
@Override
public Optional<TransactionDTO> findByReservationId(Long idReservation) {
    Optional<TransactionDTO> reservationDTO = transactionRepository.findByReservationId(idReservation).map(TransactionMapper::mapFromDto);
    if (reservationDTO.isEmpty()) {
        return Optional.empty();
    }
    return reservationDTO;
}
}
