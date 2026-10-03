package fr.esgi.plage.business;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Entity
@Getter
public class Parasol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private Short numero;

    @NotNull
    @ManyToOne
    // Il y aura une clé étrangère qui pointe
    // vers un enrengistrement de la table ligne
    private Ligne ligne;

    public Parasol(Short numero, Ligne ligne) {
        this.numero = numero;
        this.ligne = ligne;
    }

    public Parasol() {

    }

    public String getNomComplet() {
        return numero + " en ligne " + ligne.getNumero();
    }
}
