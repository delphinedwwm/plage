package fr.esgi.plage.initialisation;

import fr.esgi.plage.business.Client;
import fr.esgi.plage.business.Ligne;
import fr.esgi.plage.business.Parasol;
import fr.esgi.plage.business.Pays;
import fr.esgi.plage.repository.ClientRepository;
import fr.esgi.plage.repository.LigneRepository;
import fr.esgi.plage.repository.ParasolRepository;
import fr.esgi.plage.repository.PaysRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AjoutDonneesInitiales {

    //@Autowired
    private final ParasolRepository parasolRepository;
    private final LigneRepository ligneRepository;
    private final ClientRepository clientRepository;
    private final PaysRepository paysRepository;

    // Field injection is not recommanded
    // but @Autowired on a constructor is fine
    @Autowired
    public AjoutDonneesInitiales(ParasolRepository parasolRepository, LigneRepository ligneRepository, ClientRepository clientRepository, PaysRepository paysRepository) {
        this.parasolRepository = parasolRepository;
        this.ligneRepository = ligneRepository;
        this.clientRepository = clientRepository;
        this.paysRepository = paysRepository;
    }

    @PostConstruct
    public void init() {
        System.out.println("AjoutDonneesInitiales...");
        for (int i = 1; i <= 5; i++) {
            Ligne ligne = ligneRepository.save(new Ligne((short) i, (float) (10-i)));
            for (int j = 1; j <= 6; j++) {
                parasolRepository.save(new Parasol((short) j, ligne));
            }
        }
        Pays pays = paysRepository.save(new Pays("FR", "France"));
        clientRepository.save(new Client("toto@esgi.fr", "12345678", pays));
    }
}
