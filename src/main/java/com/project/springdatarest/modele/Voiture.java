package com.project.springdatarest.modele;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Data
@RequiredArgsConstructor
@NoArgsConstructor



public class Voiture {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    @NonNull
    private String marque;
    @NonNull
    private String modele;
    @NonNull
    private String couleur;
    @NonNull
    private String immatricule;
    @NonNull
    private int annee;
    @NonNull
    private int prix;

    // Many-to-One relationship with Proprietaire
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "proprietaire")
    @JsonIgnore
    private Proprietaire proprietaire;  // Reference to the owner
}
