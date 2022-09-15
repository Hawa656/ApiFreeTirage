package com.odc.FreeTirage.controller;

import com.odc.FreeTirage.service.PostulantTrieService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/PostulantTrie")
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class PostulantTrieController {

    @Autowired
    private final PostulantTrieService postulantTrieService;

    public int create(long idpostulant, String nom, String prenom, String numero, String email, Long idtirage_id){

        return postulantTrieService.creer(idpostulant, nom, prenom, numero, email,idtirage_id);
    }
    @GetMapping("/posttire/{idtirage}")
    public Iterable<Object[]> affToutTirage(@PathVariable long idtirage ){
        return postulantTrieService.Postulanttire(idtirage);
    }

}
