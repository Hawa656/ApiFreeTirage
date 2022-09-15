package com.odc.FreeTirage.controller;

import com.odc.FreeTirage.model.ListePostulants;
import com.odc.FreeTirage.service.ServiceListPostulant;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Listepostulants")
@CrossOrigin(origins = "http://localhost:4200")
@AllArgsConstructor
public class PostulantListController {
    //on donne un chemin d'accès qui va nous permettre d'afficher (dans postman pour le moment)
 /*   @GetMapping("/nombreListe")
    public int nombreListe(){
        return serviceListPostulant.nombreListe();
    }*/

    private final ServiceListPostulant serviceListPostulant;

    @PostMapping("/createListe")
    public ListePostulants create(@RequestBody ListePostulants listePostulants){

        return serviceListPostulant.creerListe(listePostulants);
    }
    @GetMapping("/voir")
    public List<ListePostulants> aff(ListePostulants listePostulants) {
        return serviceListPostulant.affiche(listePostulants);

    }
    //chemin pour calculer le nombre total de listes tires
    @GetMapping("/NombreListeTire")
    public int recupererTouteLesListes(){
        //*********************** .size() Renvoie le nombre d'éléments ***************************
        return serviceListPostulant.recupererListeTire().size();

    }



}
