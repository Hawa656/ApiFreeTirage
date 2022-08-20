package com.odc.FreeTirage.serviceImplt;

import com.odc.FreeTirage.model.Postulants;
import com.odc.FreeTirage.repository.PostulantsRepository;
import com.odc.FreeTirage.service.ServicePostulants;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PostulantImpl implements ServicePostulants {
    private PostulantsRepository postulantsRepository;


    @Override
    public List<Postulants> enregistrer(List<Postulants> listPost) {

        return postulantsRepository.saveAll(listPost);
    }
}
