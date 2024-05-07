package com.ms.reservation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/reservations")
public class ReservationController {

    private final Map<String, ReservationRequest> reservations = new HashMap<>();
    private final EmailService emailService;

    @Autowired
    public ReservationController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping
    public ResponseEntity<?> reserveRoom(@RequestBody ReservationRequest request) {
        // Verificar se já existe uma reserva para o mesmo horário e local
        for (ReservationRequest existingReservation : reservations.values()) {
            if (existingReservation.getRoomId().equals(request.getRoomId()) &&
                    existingReservation.getCheckInDate().equals(request.getCheckInDate()) &&
                    existingReservation.getCheckOutDate().equals(request.getCheckOutDate())) {
                // Se uma reserva já existe para o mesmo horário e local, retornar um ResponseEntity com status de erro
                return ResponseEntity.badRequest().body("Já existe uma reserva para este quarto.");
            }
        }

        // Se não houver reserva para o mesmo horário e local, proceder com a reserva
        String reservationId = UUID.randomUUID().toString();
        request.setReservationId(reservationId);

        reservations.put(reservationId, request);

        // Enviar e-mail de confirmação
        String subject = "Confirmação de Reserva";
        String body = "Sua reserva foi confirmada. ID da reserva: " + reservationId;
        emailService.sendEmail(request.getEmail(), subject, body);

        return ResponseEntity.ok("Reserva realizada com sucesso! ID da reserva: " + reservationId);
    }

    @DeleteMapping("/{reservationId}")
    public ResponseEntity<?> cancelReservation(@PathVariable String reservationId) {
        reservations.remove(reservationId);

        // Enviar e-mail de cancelamento
        String subject = "Cancelamento de Reserva";
        String body = "Sua reserva foi cancelada. ID da reserva: " + reservationId;
        emailService.sendEmail("email@example.com", subject, body);

        return ResponseEntity.ok("Reserva cancelada com sucesso!");
    }

    // Getter para reservations (não é necessário um setter)
    public Map<String, ReservationRequest> getReservations() {
        return reservations;
    }
}
