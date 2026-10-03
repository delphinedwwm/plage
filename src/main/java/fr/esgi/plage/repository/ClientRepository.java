package fr.esgi.plage.repository;

import fr.esgi.plage.business.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Long> {
    /**
     * Méthode qui renvoie tous les clients
     * résidant dans le pays dont le nom est donné en paramètre
     * @param nom
     * @return
     */
    List<Client> findByPays_Nom(String nom);

    List<Client> findByPays_NomIgnoreCase(String nom);

    boolean existsByEmail(String email);

    Client findByEmail(String email);

    Client findByEmailAndMotDePasse(String email, String motDePasse);
}