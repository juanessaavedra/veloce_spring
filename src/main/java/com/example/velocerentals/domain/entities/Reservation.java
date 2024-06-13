package com.example.velocerentals.domain.entities;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "reservations")
@Entity
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_vehicle")
    private Vehicle vehicle;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;

    private LocalDate startDate;
    private LocalDate endDate;

    private double totalPrice;

    private int status;

    }


