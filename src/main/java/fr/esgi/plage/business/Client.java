package fr.esgi.plage.business;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Email
    // Ajoute une contrainte d'unicité sur la colonne email de la table Client
    // On ne pourra pas avoir de doublons d'email
    @Column(unique = true)
    private String email;

    @Size(min=8)
    private String motDePasse;

    @NotNull
    @ManyToOne
    private Pays pays;

    public Client(String email, String motDePasse, Pays pays) {
        this.email = email;
        this.motDePasse = motDePasse;
        this.pays = pays;
    }
}
