package com.odc.FreeTirage.serviceImplt;

import com.odc.FreeTirage.model.Postulants;
import com.odc.FreeTirage.model.Tirage;
import com.odc.FreeTirage.repository.TirageRepository;
import com.odc.FreeTirage.service.TirageService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
@Component
@AllArgsConstructor
public class TirageServiceImpl implements TirageService {

    @Autowired
    public final TirageRepository tirageRepository;

    @Override
    public List<Postulants> Creer(@RequestBody Tirage tirage, List<Postulants> listAtrier, Long nbre) {
        //création d'une variable random
        Random rand = new Random();
        //declaration de la liste qui contiendra les postulants selectionnés
        List<Postulants> list = new ArrayList<>();
        for (int i = 0; i< nbre; i++)
        {
            Integer idAct = rand.nextInt(listAtrier.size());

            //while (idAct == 0 || list.contains(idAct)){
            //idAct = rand.nextInt(listAtrier.size());
            //}

            list.add(listAtrier.get(idAct));

            listAtrier.remove(listAtrier.get(idAct));
        }
        tirageRepository.save(tirage);
        return list;

    }


    @Override
    public Tirage trouverTirageParLibelle(String libelle) {

        return tirageRepository.findByLibelle(libelle);
    }

    @Override
    public int nombreTirage() {
        return tirageRepository.NombreTirage();
    }
    //total tirage
    @Override
    public int findAllNombreTirage() {
        return tirageRepository.findAll().size();
    }

    @Override
    public Iterable<Object[]> ToutTirageIdliste(long id_listepostulants) {
        return tirageRepository.RequetteAfficher(id_listepostulants);
    }

}