package com.project.springdatarest;

import static org.assertj.core.api.Assertions.assertThat;

import com.project.springdatarest.modele.Voiture;
import com.project.springdatarest.repository.VoitureRepo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)  // Utilisation de JUnit 5
@DataJpaTest  // Test JPA uniquement, avec configuration automatique d'H2, Hibernate et Spring Data
public class VoitureRepoTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private VoitureRepo voitureRepo;

    @Test
    public void ajouterVoiture() {
        // Création d'un objet Voiture
        Voiture voiture = new Voiture("MiolaCar", "Uber", "Blanche", "M-2020", 2021, 180000);

        // Persistance de l'entité en base H2
        entityManager.persistAndFlush(voiture);

        // Vérification que l'ID de la voiture n'est pas nul
        assertThat(voiture.getId()).isNotNull();
    }

    @Test
    public void supprimerVoiture() {
        // Ajout de deux voitures dans la base H2
        entityManager.persistAndFlush(new Voiture("MiolaCar", "Uber", "Blanche", "M-2020", 2021, 180000));
        entityManager.persistAndFlush(new Voiture("MiniCooper", "Uber", "Rouge", "C-2020", 2021, 180000));

        // Suppression de toutes les voitures
        voitureRepo.deleteAll();

        // Vérification que le dépôt est vide
        assertThat(voitureRepo.findAll()).isEmpty();
    }
}
