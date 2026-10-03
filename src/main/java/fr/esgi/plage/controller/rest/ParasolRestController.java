package fr.esgi.plage.controller.rest;

import fr.esgi.plage.business.Parasol;
import fr.esgi.plage.service.ParasolService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// Ce contrôleur traite des requêtes HTTP
// et renvoie des informations au format JSON
@RestController
@RequestMapping("/api/parasols")
public class ParasolRestController {

    private final ParasolService parasolService;

    public ParasolRestController(ParasolService parasolService) {
        this.parasolService = parasolService;
    }
    @GetMapping
     public List<Parasol> getParasols(){
        return parasolService.recupererParasols();
     }

}
