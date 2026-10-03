package fr.esgi.plage.controller;

import fr.esgi.plage.service.ParasolService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

// Cette classe traite des requêtes HTTP
@Controller // Annotation
public class ParasolController {

    // Le contrôleur dépend du service ParasolService
    private final ParasolService parasolService;

    public ParasolController(ParasolService parasolService) {
        this.parasolService = parasolService;
    }

    @GetMapping({"/", "/parasols"})
    public ModelAndView getAccueil() {
        // On instancie une Danette Pop, sa vue est index.html
        ModelAndView modelAndView = new ModelAndView("index");
        // On ajoute tous les parasols dans le modele
        modelAndView.addObject("parasols", parasolService.recupererParasols());
        return modelAndView;
    }
}
