package com.example.velocerentals.repositories.reservation;

import com.example.velocerentals.domain.entities.Reservation;
import com.example.velocerentals.mapping.dtos.ReservationDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Optional;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    Optional<Reservation> findByUserId(Long idUser);

    Optional<Reservation> findByVehicleId(Long idVehicle);

    Optional<Reservation> findByStartDate(LocalDate startDate);

    Optional<Reservation> findByEndDate(LocalDate endDate);
}
