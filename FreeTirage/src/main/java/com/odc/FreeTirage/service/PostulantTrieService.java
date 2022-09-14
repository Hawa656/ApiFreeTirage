package com.odc.FreeTirage.service;

import org.springframework.stereotype.Service;

@Service
public interface PostulantTrieService {

    int creer(Long idpostulant, String nom, String prenom, String numero, String email, Long idtirage_id);
}
