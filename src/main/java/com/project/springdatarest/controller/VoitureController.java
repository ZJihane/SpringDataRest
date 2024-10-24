package com.project.springdatarest.controller;


import com.project.springdatarest.modele.Voiture;
import com.project.springdatarest.repository.VoitureRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/voitures")
@CrossOrigin(origins = "http://localhost:3000")

public class VoitureController {

    @Autowired
    private VoitureRepo voitureRepo;

    // Récupérer toutes les voitures
    @GetMapping
    public Iterable<Voiture> getVoitures() {
        return voitureRepo.findAll();
    }

    // Ajouter une nouvelle voiture
    @PostMapping // Ajoutez cette méthode pour gérer les requêtes POST
    public Voiture createVoiture(@RequestBody Voiture voiture) {
        return voitureRepo.save(voiture);
    }

    // Suppression d'une voiture par son ID
    @DeleteMapping("/{id}")
    public void deleteVoiture(@PathVariable Long id) {
        voitureRepo.deleteById(id);
    }

}



