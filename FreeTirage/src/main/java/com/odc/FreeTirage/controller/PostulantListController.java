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

    private final ServiceListPostulant serviceListPostulant;

    @PostMapping("/createListe")
    public ListePostulants create(@RequestBody ListePostulants listePostulants){

        return serviceListPostulant.creerListe(listePostulants);
    }
    @GetMapping("/voir")
    public List<ListePostulants> aff(ListePostulants listePostulants) {
        return serviceListPostulant.affiche(listePostulants);
    }

}
