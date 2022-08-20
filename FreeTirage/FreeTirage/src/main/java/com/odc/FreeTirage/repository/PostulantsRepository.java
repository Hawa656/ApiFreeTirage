package com.odc.FreeTirage.repository;

import com.odc.FreeTirage.model.Postulants;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;



@Repository
public interface PostulantsRepository extends JpaRepository<Postulants, Long> {
  //  Postulants findByEmail(String email);

}
