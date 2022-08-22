package com.odc.FreeTirage.repository;

import com.odc.FreeTirage.model.PostulantTire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface PostulantTireRepository extends JpaRepository<PostulantTire, Long> {

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO postulant_tire(id_postulants,nom,prenom,numero,email,idtirageid) VALUES(?,?,?,?,?,?)",nativeQuery = true)
    public int INSERTPOSTTIRE(Long idpostulants, String nom, String prenom, String numero,String email, Long idtirageid );
}
