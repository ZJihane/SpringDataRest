package com.project.springdatarest;

import com.project.springdatarest.modele.Proprietaire;
import com.project.springdatarest.modele.Voiture;
import com.project.springdatarest.repository.ProprietaireRepo;
import com.project.springdatarest.repository.VoitureRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringDataRestApplication {

    @Autowired
    private VoitureRepo repository;
    @Autowired
    private ProprietaireRepo proprietaireRepo;

    public static void main(String[] args) {
        SpringApplication.run(SpringDataRestApplication.class, args);
    }

    @Bean
    CommandLineRunner runner() {
        return args -> {
            // Creating Proprietaire objects
            Proprietaire proprietaire1 = new Proprietaire("Ali", "Hassan");
            Proprietaire proprietaire2 = new Proprietaire("Najat", "Bani");

            // Saving Proprietaire objects to the repository
            proprietaireRepo.save(proprietaire1);
            proprietaireRepo.save(proprietaire2);

            // Creating Voiture objects and assigning Proprietaire
            Voiture voiture1 = new Voiture("Toyota", "Corolla", "Grise", "A-1-9090", 2018, 95000);
            voiture1.setProprietaire(proprietaire1); // Assign proprietaire1 to voiture1

            Voiture voiture2 = new Voiture("Ford", "Fiesta", "Rouge", "A-2-8090", 2015, 90000);
            voiture2.setProprietaire(proprietaire1); // Assign proprietaire1 to voiture2

            Voiture voiture3 = new Voiture("Honda", "CRV", "Bleu", "A-3-7090", 2016, 140000);
            voiture3.setProprietaire(proprietaire2); // Assign proprietaire2 to voiture3

            // Saving Voiture objects to the repository
            repository.save(voiture1);
            repository.save(voiture2);
            repository.save(voiture3);
        };
    }
}
