package fr.esgi.plage.controller.rest;

import fr.esgi.plage.business.Reservation;
import fr.esgi.plage.service.ReservationService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.PrincipalMethodArgumentResolver;

@RestController
@AllArgsConstructor
@RequestMapping("/api/reservations")
public class ReservationRestController {

    private final ReservationService reservationService;
    /*
    public ReservationRestController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }
     */
    @PostMapping
    @Operation(summary = "Ajoute une nouvelle reservation")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation postReservation(@RequestBody @Valid Reservation reservation) {
        System.out.println(SecurityContextHolder.getContext().getAuthentication().getName());
        // TODO associer la nouvelle reservation à la personne connectée
        return reservationService.ajouterReservation(reservation);
    }
}
