package com.example.velocerentals.controllers;


import com.example.velocerentals.mapping.dtos.ReservationDTO;
import com.example.velocerentals.services.reservations.ReservationService;
import jakarta.validation.Valid;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/reservations")

public class ReservationController {


    @Autowired
    private ReservationService reservationService;

    /**
     * Recupera una lista de todas las reservas.
     */
    @GetMapping(value = "/get-reservations")
    public List<ReservationDTO> getReservations() {
        return reservationService.listReservations();
    }

    /**
     * Recupera una reserva por su ID.
     */
    @GetMapping(value = "/get-reservations-id/{id}")
    public ReservationDTO byIdReservation(@PathVariable Long id) throws BadRequestException {
        return reservationService.byIdReservation(id);
    }

    /**
     * Recupera una reserva por su ID de vehículo.
     */
    @GetMapping(value = "/get-reservations-idvehicle/{idVehicle}")
    public Optional<ReservationDTO> byIdVehicle(@PathVariable Long idVehicle) throws BadRequestException {
        return reservationService.findByVehicleId(idVehicle);
    }

    /**
     * Recupera una reserva por su ID de usuario.
     */
    @GetMapping(value = "/get-reservations-iduser/{idUser}")
    public Optional<ReservationDTO> byIdUser(@PathVariable Long idUser) throws BadRequestException {
        return reservationService.findByUserId(idUser);
    }


    @GetMapping(value = "/get-reservations-startDate/{startDate}")
    public Optional<ReservationDTO> byStartDate(@PathVariable LocalDate startDate) throws BadRequestException {
        return reservationService.findByStartDate(startDate);
    }

    @GetMapping(value = "/get-reservations-endDate/{endDate}")
    public Optional<ReservationDTO> byEndDate(@PathVariable LocalDate endDate) throws BadRequestException {
        return reservationService.findByEndDate(endDate);
    }

    /**
     * Elimina una reserva por su ID.
     */
    @DeleteMapping(value = "/delete-reservation/{id}")
    public void removeReservation(@PathVariable Long id) {
        reservationService.removeReservation(id);
    }

    /**
     * Crea una nueva reserva.
     */
    @PostMapping(value = "/create-reservation")
    public void createReservation(@RequestBody @Valid ReservationDTO reservationDTO) {
        reservationService.saveReservation(reservationDTO);
    }

}