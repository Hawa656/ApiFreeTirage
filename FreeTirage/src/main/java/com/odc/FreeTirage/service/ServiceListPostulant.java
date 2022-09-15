package com.odc.FreeTirage.service;

import com.odc.FreeTirage.model.ListePostulants;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ServiceListPostulant {
    ListePostulants creerListe(ListePostulants listePostulants);
    ListePostulants trouverListeParLibelle(String libelle);
    List<ListePostulants> affiche(ListePostulants listePostulants);
    /*//**2** on declare une methode qui est lier à notre repository et on va dans serviceImpl
    int nombreListe();
     */
//pour que à chaque fois qu'on fait un tirage sur une liste ,le nombre de tirage soit afficher
      ListePostulants mettreAJourLeNombredeListe(Long listePostulants);
//*********methode qui va nous permettre de calculer le nombre total de tirage des listes********************
    List<ListePostulants> recupererListeTire();


}
