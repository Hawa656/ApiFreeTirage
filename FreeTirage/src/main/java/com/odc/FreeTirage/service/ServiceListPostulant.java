package com.odc.FreeTirage.service;

import com.odc.FreeTirage.model.ListePostulants;
import org.springframework.stereotype.Service;

@Service
public interface ServiceListPostulant {
    ListePostulants creerListe(ListePostulants listePostulants);
    ListePostulants trouverListeParLibelle(String libelle);
}
