package com.odc.FreeTirage.repository;

import com.odc.FreeTirage.model.ListePostulants;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface ListPostulRepository extends JpaRepository<ListePostulants, Long> {

    ListePostulants findByLibele(String libelle);
    //**1** on commence ici dans le repository avec une methode query qui permet de compter
    // les listes existant dans la base de donnée et on va dans service
    /*@Query(value = "SELECT COUNT(*) FROM `liste_postulants`;",nativeQuery = true)
    public int NombreListe();
     */
//Requette qui permet d'afficher les element de listes postulants dont le nombre de tirage est different de 0
    @Query(value = "select * from liste_postulants where nombre_tirage !=0", nativeQuery = true)
    public List<ListePostulants> FIND_All_Liste_Tire();


    /*@Modifying
    @Transactional
    @Query(value = "insert into postulants idlist_id_liste values = :idlist_id_liste", nativeQuery = true)
    public int INSERTIDLIST(@Param("idlist_id_liste") Long idlist_id_liste);*/
}
