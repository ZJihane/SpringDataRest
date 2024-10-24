package com.project.springdatarest.modele;

import jakarta.persistence.*;
import lombok.*;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

@Entity
@Data
@RequiredArgsConstructor
@NoArgsConstructor // Needed for JPA
public class Proprietaire {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id; // No @NonNull here because it's auto-generated

    @NonNull
    private String nom;

    @NonNull
    private String prenom;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "proprietaire")
    @JsonIgnore
    private List<Voiture> voitures;
}
