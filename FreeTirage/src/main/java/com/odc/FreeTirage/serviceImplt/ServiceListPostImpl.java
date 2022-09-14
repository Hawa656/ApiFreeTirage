package com.odc.FreeTirage.serviceImplt;

import com.odc.FreeTirage.model.ListePostulants;
import com.odc.FreeTirage.repository.ListPostulRepository;
import com.odc.FreeTirage.service.ServiceListPostulant;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ServiceListPostImpl implements ServiceListPostulant {
    final private ListPostulRepository listPostulRepository;
    @Override
    public ListePostulants creerListe(ListePostulants listePostulants) {
        return listPostulRepository.save(listePostulants);
    }

    @Override
    public ListePostulants trouverListeParLibelle(String libelle) {
        return listPostulRepository.findByLibele(libelle);
    }

    @Override
    public List<ListePostulants> affiche(ListePostulants listePostulants) {
        return listPostulRepository.findAll();
    }
}
