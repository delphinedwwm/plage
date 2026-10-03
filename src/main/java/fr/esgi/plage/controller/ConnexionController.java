package fr.esgi.plage.controller;

import fr.esgi.plage.business.Client;
import fr.esgi.plage.service.ClientService;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@AllArgsConstructor
public class ConnexionController {

    private final ClientService clientService;
    private final HttpSession httpSession;

    @GetMapping("connexion")
    public ModelAndView getConnexion() {
        ModelAndView modelAndView = new ModelAndView("connexion");
        return modelAndView;
    }

    @PostMapping("connexion")
    public ModelAndView postConnexion(
            @RequestParam String email,
            @RequestParam String motDePasse
    ) {
        System.out.println("postConnexion, email=" + email);
        Client client = clientService.recupererClient(email, motDePasse);
        if (client!=null) {
            // On place le client dans la session HTTP
            httpSession.setAttribute("client", client);
            return new ModelAndView("redirect:parasols");
        }
        else {
            return new ModelAndView("redirect:connexion");
        }
    }
}