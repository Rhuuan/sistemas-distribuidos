package com.ms.cancellations;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/cancellations")
public class CancellationController {

    // Reutiliza o mapa de reservas do ReservationController
    private Map<String, String> reservations;

    public CancellationController() {
        this.reservations = new HashMap<>();
    }

    @DeleteMapping("/{reservationId}")
    public ResponseEntity<?> cancelReservation(@PathVariable String reservationId) {
        // Lógica simulada: remove a reserva do mapa
        reservations.remove(reservationId);

        return ResponseEntity.ok("Reserva cancelada com sucesso!");
    }

    // Getter e setter para reservations
    public Map<String, String> getReservations() {
        return reservations;
    }

    public void setReservations(Map<String, String> reservations) {
        this.reservations = reservations;
    }
}