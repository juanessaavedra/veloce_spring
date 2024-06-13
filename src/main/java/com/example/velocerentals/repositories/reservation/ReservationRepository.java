package com.example.velocerentals.repositories.reservation;

import com.example.velocerentals.domain.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    Optional<Reservation> findByUserId(Long idUser);

    Optional<Reservation> findByVehicleId(Long idVehicle);
}
