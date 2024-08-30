package com.hotel.services;

import com.hotel.models.Reservation;
import com.hotel.models.Room;

import java.util.ArrayList;
import java.util.List;

public class ReservationService {
    private List<Reservation> reservations = new ArrayList<>();
    private int reservationCounter = 1;

    public Reservation makeReservation(Room room, String customerName, String checkInDate, String checkOutDate) {
        double totalAmount = calculateTotalAmount(room, checkInDate, checkOutDate);
        Reservation reservation = new Reservation(reservationCounter++, room, customerName, checkInDate, checkOutDate, totalAmount, false);
        reservations.add(reservation);
        return reservation;
    }

    public Reservation findReservationById(int reservationId) {
        return reservations.stream()
                .filter(reservation -> reservation.getReservationId() == reservationId)
                .findFirst()
                .orElse(null);
    }

    private double calculateTotalAmount(Room room, String checkInDate, String checkOutDate) {
        // For simplicity, assume 1 night stay (You can implement date difference logic)
        return room.getPricePerNight();
    }

    public List<Reservation> getAllReservations() {
        return reservations;
    }
}