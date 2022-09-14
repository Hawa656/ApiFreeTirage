package com.odc.FreeTirage.repository;

import com.odc.FreeTirage.model.Postulants;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PostulantsRepository extends JpaRepository<Postulants, Long> {

    @Query(value = "select * from postulants where idliste_id_listepostulants = :id_listepostulants", nativeQuery = true)
    public List<Postulants> FINDIDPOSTLIST(@Param("id_listepostulants") Long id_listepostulants);
  //  Postulants findByEmail(String email);

}
