package com.odc.FreeTirage.service;

import com.odc.FreeTirage.model.Postulants;
import com.odc.FreeTirage.model.Tirage;

import java.util.List;

public interface TirageService {
    List<Postulants> Creer(Tirage tirage, List<Postulants> listAtrier, Long nbre);

    //List<Postulants> creer(@RequestBody Tirage tirage, List<Postulants> listAtrier, Long nbre);

    Tirage trouverTirageParLibelle(String libelle);
    //methode pour compter le nombre de tirage
    int nombreTirage();
    // total tirage

    int findAllNombreTirage();
}
