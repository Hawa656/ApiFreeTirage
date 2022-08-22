package com.odc.FreeTirage.controller;

import com.odc.FreeTirage.service.PostulantTrieService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/PostulantTrie")
@AllArgsConstructor
public class PostulantTrieController {

    @Autowired
    private final PostulantTrieService postulantTrieService;

    public int create(long idpostulant, String nom, String prenom, String numero, String email, Long idtirage_id){

        return postulantTrieService.creer(idpostulant, nom, prenom, numero, email,idtirage_id);
    }


}
