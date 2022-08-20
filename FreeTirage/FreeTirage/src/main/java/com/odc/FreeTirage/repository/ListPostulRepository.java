package com.odc.FreeTirage.repository;

import com.odc.FreeTirage.model.ListePostulants;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ListPostulRepository extends JpaRepository<ListePostulants, Long> {
}
