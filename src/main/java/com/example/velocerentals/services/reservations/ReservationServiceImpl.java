package com.example.velocerentals.services.reservations;


import com.example.velocerentals.mapping.dtos.ReservationDTO;
import com.example.velocerentals.mapping.mappers.ReservationMapper;
import com.example.velocerentals.repositories.reservation.ReservationRepository;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;


    /**
 * Obtiene todas las reservas de la base de datos y las convierte a DTOs.
 */
@Override
public List<ReservationDTO> listReservations() {
    return reservationRepository.findAll().stream().map(ReservationMapper::mapFromDto).toList();
}

/**
 * Busca una reserva por su ID y la convierte a un DTO.
 * Si no se encuentra la reserva, lanza una excepción BadRequestException.
 */
@Override
public ReservationDTO byIdReservation(Long id) throws BadRequestException {
    return ReservationMapper.mapFromDto(reservationRepository.findById(id).orElseThrow(() -> new BadRequestException("Reservation not found")));
}

/**
 * Elimina una reserva de la base de datos por su ID.
 */
@Override
public void removeReservation(Long id) {
    reservationRepository.deleteById(id);
}

/**
 * Añade una nueva reserva a la base de datos y la convierte a un DTO.
 */
@Override
public ReservationDTO addReservation(ReservationDTO reservationDTO) {
    return ReservationMapper.mapFromDto(reservationRepository.save(ReservationMapper.mapFromModel(reservationDTO)));
}

/**
 * Busca una reserva por el ID de usuario y la convierte a un DTO.
 * Si no se encuentra la reserva, devuelve un Optional vacío.
 */
@Override
public Optional<ReservationDTO> findByUserId(Long idUser) {
    Optional<ReservationDTO> reservationDTO = reservationRepository.findByUserId(idUser).map(ReservationMapper::mapFromDto);
    if(reservationDTO.isEmpty()){
        return Optional.empty();
    }
    return reservationDTO;
}

/**
 * Busca una reserva por el ID del vehículo y la convierte a un DTO.
 * Si no se encuentra la reserva, devuelve un Optional vacío.
 */
@Override
public Optional<ReservationDTO> findByVehicleId(Long idVehicle) {
    Optional<ReservationDTO> reservationDTO = reservationRepository.findByVehicleId(idVehicle).map(ReservationMapper::mapFromDto);
    if(reservationDTO.isEmpty()){
        return Optional.empty();
    }
    return reservationDTO;
}
    }



