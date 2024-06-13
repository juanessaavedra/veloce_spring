package com.example.velocerentals.mapping.mappers;

import com.example.velocerentals.domain.entities.Reservation;
import com.example.velocerentals.mapping.dtos.ReservationDTO;


public class ReservationMapper {

    public static Reservation mapFromModel(ReservationDTO reservationDTO) {
        return Reservation.builder()
                .id(reservationDTO.id())
                .vehicle(reservationDTO.vehicle())
                .user(reservationDTO.user())
                .startDate(reservationDTO.startDate())
                .endDate(reservationDTO.endDate())
                .totalPrice(reservationDTO.totalPrice())
                .status(reservationDTO.status())
                .build();

    }

    public static ReservationDTO mapFromDto(Reservation reservation) {
        return ReservationDTO.builder()
                .id(reservation.getId())
                .vehicle(reservation.getVehicle())
                .user(reservation.getUser())
                .startDate(reservation.getStartDate())
                .endDate(reservation.getEndDate())
                .totalPrice(reservation.getTotalPrice())
                .status(reservation.getStatus())
                .build();
    }
}
