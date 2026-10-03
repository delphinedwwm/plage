package fr.esgi.plage.controller;

import fr.esgi.plage.business.Client;
import fr.esgi.plage.business.Reservation;
import fr.esgi.plage.service.ClientService;
import fr.esgi.plage.service.ParasolService;
import fr.esgi.plage.service.ReservationService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;

@Controller
@AllArgsConstructor
@SessionAttributes(value = "reservation")
public class ReservationController {

    private final ReservationService reservationService;
    private final ParasolService parasolService;
    private final ClientService clientService;
    private final HttpSession httpSession;

    @GetMapping("reservation")
    public ModelAndView getReservation() {
        ModelAndView modelAndView = new ModelAndView("reservation");
        Reservation reservation = new Reservation();
        reservation.setDateDebut(LocalDate.now());
        reservation.setClient((Client) httpSession.getAttribute("client"));
        // On envoie un objet reservation à la vue
        modelAndView.addObject("reservation", reservation);
        modelAndView.addObject("parasols", parasolService.recupererParasols());
        return modelAndView;
    }

    @PostMapping("reservation")
    public ModelAndView postReservation(@Valid @ModelAttribute Reservation reservation, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            ModelAndView mav = getReservation();
            mav.addObject("errorMessage", bindingResult.getFieldError().getDefaultMessage());
            mav.addObject("reservation", reservation);
            return mav;
        }
        reservationService.ajouterReservation(reservation);
        return new ModelAndView("redirect:parasols");
    }
}