package fr.esgi.plage.controller.rest;

import fr.esgi.plage.business.Client;
import fr.esgi.plage.controller.rest.request.ConnexionRequest;
import fr.esgi.plage.service.ClientService;
import fr.esgi.plage.util.JwtUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/connexion")
@AllArgsConstructor
public class ConnexionRestController {

    private final ClientService clientService;
    private final JwtUtil jwtUtil;

    @PostMapping
    public String postConnexion(@RequestBody ConnexionRequest connexionRequest) {
        Client client = clientService.recupererClient(connexionRequest.getEmail(), connexionRequest.getMotDePasse());
        if (client!=null) {
            String role = "ROLE_USER";
            String token = jwtUtil.generateToken(connexionRequest.getEmail(), role);
            return token;
        }
        else {
            return null;
        }
    }

}
