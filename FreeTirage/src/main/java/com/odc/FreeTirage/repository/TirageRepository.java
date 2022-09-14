package com.odc.FreeTirage.repository;

//import com.odc.FreeTirage.model.Tirage;
import com.odc.FreeTirage.model.Tirage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TirageRepository extends JpaRepository<Tirage, Long> {
    Tirage findByLibelle(String libelle);

}
