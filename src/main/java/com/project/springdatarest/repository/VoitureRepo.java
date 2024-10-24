package com.project.springdatarest.repository;

import com.project.springdatarest.modele.Voiture;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface VoitureRepo extends CrudRepository<Voiture, Long> {

    List<Voiture> findByMarque(String marque);

    List<Voiture> findByCouleur(String couleur);

    List<Voiture> findByAnnee(int annee);

    List<Voiture> findByMarqueAndModele(String marque, String modele);

    List<Voiture> findByMarqueOrCouleur(String marque, String couleur);

    List<Voiture> findByMarqueOrderByAnneeAsc(String marque);

    List<Voiture> findByMarqueEndsWith(String marque);

}
