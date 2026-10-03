package fr.esgi.plage.business;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor // Annotation qui génère avant la compilation le constructeur par défaut
public class Ligne {

    @NotNull
    @Id
    private Short numero;
    @NotNull
    private Float coefficient;

    public Ligne(Short numero, Float coefficient) {
        this.numero = numero;
        this.coefficient = coefficient;
    }
}
