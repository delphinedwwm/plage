package fr.esgi.plage.service.impl;

import fr.esgi.plage.business.Parasol;
import fr.esgi.plage.repository.ParasolRepository;
import fr.esgi.plage.service.ParasolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParasolServiceImpl implements ParasolService {

    // Annotation Rétro à ne pas utiliser (Benji attention !!)
    // @Autowired
    // dépendance : le service dépend de la repository
    // toujours déclarer ses dépendances en final
    private final ParasolRepository parasolRepository;

    // injection par constructeur
    public ParasolServiceImpl(ParasolRepository parasolRepository) {
        this.parasolRepository = parasolRepository;
    }

    @Override
    public List<Parasol> recupererParasols() {
        return parasolRepository.findAll();
    }
}
