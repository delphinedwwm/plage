package fr.esgi.plage.repository;

import fr.esgi.plage.business.Ligne;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LigneRepository extends JpaRepository<Ligne, Long> {

}
