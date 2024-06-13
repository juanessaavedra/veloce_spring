package com.example.velocerentals.repositories.transaction;

import com.example.velocerentals.domain.entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    Optional<Transaction> findByReservationId(Long idReservation);
}
