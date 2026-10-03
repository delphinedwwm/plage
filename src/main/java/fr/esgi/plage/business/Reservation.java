package fr.esgi.plage.business;

import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false) // JPA validation ds BDD
    private Long id;

    @ManyToOne
    @NotNull(message="Le client n'a pas été renseigné") // c'est la validation avant la BDD
    private Client client;

    @ManyToMany
    @NotEmpty(message="Merci de choisir un ou plusieurs parasols") // validation balise select
    //@Size(min=1)
    private List<Parasol> parasols;

    @DateTimeFormat(iso=DateTimeFormat.ISO.DATE)
    @FutureOrPresent(message="Merci de préciser une date future ou aujourd'hui")
    private LocalDate dateDebut;
    private LocalDate dateFin;

}
