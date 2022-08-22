package com.odc.FreeTirage.service;

import com.odc.FreeTirage.model.Postulants;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Service
public interface ServicePostulants {
    List<Postulants> enregistrer(List<Postulants> listPost);

    ArrayList<Postulants> INSERPostulant(MultipartFile file, String nompostulants, String prenompostulants, String numeropostulants, String emailpostulants);

    Postulants creerPostulant(Postulants postulants);

    List<Postulants>TrouveridPostList(Long idListe);

}
