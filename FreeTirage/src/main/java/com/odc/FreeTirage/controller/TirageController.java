package com.odc.FreeTirage.controller;

import com.odc.FreeTirage.model.ListePostulants;
import com.odc.FreeTirage.model.Postulants;
import com.odc.FreeTirage.model.Tirage;
import com.odc.FreeTirage.service.PostulantTrieService;
import com.odc.FreeTirage.service.ServiceListPostulant;
import com.odc.FreeTirage.service.ServicePostulants;
import com.odc.FreeTirage.service.TirageService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tirage")
@AllArgsConstructor
public class TirageController {
    @Autowired
    //definition du service tirage
    private final TirageService tirageService;
    //definition du service postulant trié
    private final PostulantTrieService postulantTrieService;
    //definition du service postulant service
    private final ServicePostulants servicePostulants;
    //definition du service postulant trié
    private final ServiceListPostulant serviceListPostulant;

    @PostMapping("/createTirage/{libelle_liste}/{nbre}")
    public  String create(@RequestBody Tirage tirage, @PathVariable String libelle_liste, @PathVariable Long nbre){
        ListePostulants liste = serviceListPostulant.trouverListeParLibelle(libelle_liste);
        List<Postulants> postulants = servicePostulants.TrouveridPostList(liste.getId_listepostulants());

        List<Postulants> lp = tirageService.Creer(tirage, postulants, nbre);//recuperation des id des postulant tiré
         long idTirage = tirageService.trouverTirageParLibelle(tirage.getLibelle()).getIdTirage();

         for (Postulants p : lp){
             postulantTrieService.creer(p.getIdPostulants(), p.getNom(), p.getPrenom(), p.getNumero(), p.getEmail(), idTirage);
         }

         return "succes";
    }
}
