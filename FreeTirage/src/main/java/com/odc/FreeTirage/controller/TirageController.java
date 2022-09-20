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

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/tirage")
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
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
    public  String create(@RequestBody Tirage tirage, @PathVariable("libelle_liste") String libelle_liste, @PathVariable Long nbre){

        ListePostulants liste = serviceListPostulant.trouverListeParLibelle(libelle_liste);

        List<Postulants> postulants = servicePostulants.TrouveridPostList(liste.getId_listepostulants());

        tirage.setListePostulants(liste);
        tirage.setNbreTire(nbre);

        serviceListPostulant.mettreAJourLeNombredeListe(liste.getId_listepostulants());

        Date d = new Date();
        tirage.setDate(d);



        List<Postulants> lp = tirageService.Creer(tirage, postulants, nbre);//recuperation des id des postulant tiré
         long idTirage = tirageService.trouverTirageParLibelle(tirage.getLibelle()).getIdTirage();

         for (Postulants p : lp){
             postulantTrieService.creer(p.getIdPostulants(), p.getNom(), p.getPrenom(), p.getNumero(), p.getEmail(), idTirage);
         }

         return "succes";
    }

    @GetMapping("/toutTirageIdListe/{id_listepostulants}")
    public Iterable<Object[]> affToutTirage(@PathVariable long id_listepostulants ){
        return tirageService.ToutTirageIdliste(id_listepostulants);
    }


    @GetMapping("/nombreTirage")
    public int nombretirage() {
        return tirageService.nombreTirage();
    }
    // chemin total tirage
    @GetMapping("/totalTirage")
    public int totalTirage(){
        return tirageService.findAllNombreTirage();
    }
}
