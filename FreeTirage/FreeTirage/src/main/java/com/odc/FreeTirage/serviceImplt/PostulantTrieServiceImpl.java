package com.odc.FreeTirage.serviceImplt;

import com.odc.FreeTirage.repository.PostulantTireRepository;
import com.odc.FreeTirage.service.PostulantTrieService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PostulantTrieServiceImpl implements PostulantTrieService {


    @Autowired
    private final PostulantTireRepository postulantTireRepository;

    @Override
    public int creer(Long idpostulant, String nom, String prenom, String numero, String email, Long idtirage_id) {
        return postulantTireRepository.INSERTPOSTTIRE(idpostulant, nom, prenom, numero, email, idtirage_id);
    }
}
