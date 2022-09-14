package com.odc.FreeTirage.service;

import com.odc.FreeTirage.model.ListePostulants;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ServiceListPostulant {
    ListePostulants creerListe(ListePostulants listePostulants);
    ListePostulants trouverListeParLibelle(String libelle);
    List<ListePostulants> affiche(ListePostulants listePostulants);
}
