package com.example.velocerentals.services.reservations;

import com.example.velocerentals.mapping.dtos.ReservationDTO;
import org.apache.coyote.BadRequestException;

import java.util.List;
import java.util.Optional;

public interface ReservationService {


    List<ReservationDTO> listReservations();

    ReservationDTO byIdReservation(Long id) throws BadRequestException;

    void removeReservation(Long id);

    ReservationDTO addReservation(ReservationDTO reservationDTO);

    Optional<ReservationDTO> findByUserId(Long idUser);

    Optional<ReservationDTO> findByVehicleId(Long idVehicle);
}
