package fr.esgi.plage.service;

import fr.esgi.plage.business.Client;

public interface ClientService {

    Client recupererClient(String email, String motDePasse);

    Client recupererClient(String email);
}
