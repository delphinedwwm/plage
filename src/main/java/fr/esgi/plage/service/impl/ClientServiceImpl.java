package fr.esgi.plage.service.impl;

import fr.esgi.plage.business.Client;
import fr.esgi.plage.repository.ClientRepository;
import fr.esgi.plage.service.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

    @Override
    public Client recupererClient(String email, String motDePasse) {
        // On invoque une méthode dérivée de la repository
        return clientRepository.findByEmailAndMotDePasse(email, motDePasse);
    }

    @Override
    public Client recupererClient(String email) {
        return clientRepository.findByEmail(email);
    }

}