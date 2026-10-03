package fr.esgi.plage.repository;

import fr.esgi.plage.business.Pays;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaysRepository extends JpaRepository<Pays, String> {
}