package com.odc.FreeTirage.controller;

import com.odc.FreeTirage.model.ListePostulants;
import com.odc.FreeTirage.service.ServiceListPostulant;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Listepostulants")
@AllArgsConstructor
public class PostulantListController {

    private final ServiceListPostulant serviceListPostulant;

    @PostMapping("/createListe")
    public ListePostulants create(@RequestBody ListePostulants listePostulants){

        return serviceListPostulant.creerListe(listePostulants);
    }

}
