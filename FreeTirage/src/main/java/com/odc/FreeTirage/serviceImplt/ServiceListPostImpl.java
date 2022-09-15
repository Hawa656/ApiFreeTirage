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
        //l'initialisation de l'attribut NombreTirage à zero avant le tirage
        //ça s'autoincremente quand on fait des gtirages
        listePostulants.setNombreTirage(0);
        return listPostulRepository.save(listePostulants);
    }

    @Override
    public ListePostulants trouverListeParLibelle(String libelle) {
        return listPostulRepository.findByLibele(libelle);
    }
//pour que à chaque fois qu'on fait un tirage sur une liste ,le nombre de tirage soit afficher
    @Override
    public ListePostulants mettreAJourLeNombredeListe(Long id_listepostulants) {
        //recuperation de la liste postulant par son id
        return listPostulRepository.findById(id_listepostulants).
                map(lp -> {
                  //recuperation de la valeur de l'attribut NombreTirage pour l'incrementer
                    lp.setNombreTirage(lp.getNombreTirage() + 1);

                    return listPostulRepository.save(lp);
                }).orElseThrow(() -> new RuntimeException("liste mise a jour avec succès"));
    }

    @Override
    public List<ListePostulants> affiche(ListePostulants listePostulants) {

        return listPostulRepository.findAll();
    }

   //**3** implementation de la methode du service qui retourne le nombre de tirage effectuée et on va dans controller
    // @Override
    //public int nombreListe() {
      //  return listPostulRepository.NombreListe();
    //}

    @Override
    public List<ListePostulants> recupererListeTire() {
        return listPostulRepository.FIND_All_Liste_Tire();
    }
}
