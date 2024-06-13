package com.example.velocerentals.domain.entities;


import com.example.velocerentals.domain.enums.PayMethods;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "transactions")
@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_reservation")
    private Reservation reservation;

    private double totalAmount;

    private LocalDateTime dateTime;

    @Enumerated(EnumType.STRING)
    private PayMethods payMethods;

    private int status;

}
