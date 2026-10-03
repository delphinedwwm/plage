package fr.esgi.plage.repository;

import fr.esgi.plage.business.Parasol;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ParasolRepository extends JpaRepository<Parasol, Long> {

    List<Parasol> findAll();

    Parasol save(Parasol parasol);
}
