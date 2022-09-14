package com.odc.FreeTirage.repository;

import com.odc.FreeTirage.model.ListePostulants;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
@Repository
public interface ListPostulRepository extends JpaRepository<ListePostulants, Long> {

    ListePostulants findByLibele(String libelle);


    /*@Modifying
    @Transactional
    @Query(value = "insert into postulants idlist_id_liste values = :idlist_id_liste", nativeQuery = true)
    public int INSERTIDLIST(@Param("idlist_id_liste") Long idlist_id_liste);*/
}
