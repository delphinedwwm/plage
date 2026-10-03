package fr.esgi.plage.repository;

import fr.esgi.plage.business.Client;
import fr.esgi.plage.business.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    // Méthodes dérivées :

    List<Reservation> findByClient(Client client);

    List<Reservation> findByClientId(Long id);

    List<Reservation> findByClientEmail(String email);

    List<Reservation> findByClientEmailIgnoreCase(String email);

    List<Reservation> findByClientPaysNom(String nom);

    List<Reservation> findByDateDebutGreaterThanEqualAndDateFinLessThanEqual(LocalDate dateDebut, LocalDate dateFin);

    List<Reservation> findByDateDebutGreaterThanEqualAndDateFinLessThanEqualAndClient(LocalDate dateDebut, LocalDate dateFin, Client client);

    long countByDateDebutGreaterThanEqualAndDateFinLessThanEqualAndClient(LocalDate dateDebut, LocalDate dateFin, Client client);

    long deleteByDateDebutGreaterThanEqualAndDateFinLessThanEqualAndClient(LocalDate dateDebut, LocalDate dateFin, Client client);

    List<Reservation> findByDateDebutBetween(LocalDate dateDebut, LocalDate dateFin);

}