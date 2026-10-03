package fr.esgi.plage.service.impl;

import fr.esgi.plage.business.Reservation;
import fr.esgi.plage.repository.ReservationRepository;
import fr.esgi.plage.service.ReservationService;
import org.springframework.stereotype.Service;

/**
 * Ce service va servir au contrôleur ReservationController
 * et au contrôleur ReservationRestController
 */
@Service
public class ReservationServiceImpl implements ReservationService {

    private final ReservationRepository reservationRepository;

    public ReservationServiceImpl(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    // si on met tout en haut @AllArgsConstructor on n'a plus besoin des lignes 17 à 19

    @Override
    public Reservation ajouterReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }
}
