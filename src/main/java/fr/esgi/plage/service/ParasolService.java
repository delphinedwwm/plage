package fr.esgi.plage.service;

import fr.esgi.plage.business.Parasol;

import java.util.List;

// L'interface contient uniquement des déclarations
// de méthodes (comme l'ardoise du restaurant)
public interface ParasolService {

    // méthode permettant de récupérer tous les parasols
    List<Parasol> recupererParasols();
}
