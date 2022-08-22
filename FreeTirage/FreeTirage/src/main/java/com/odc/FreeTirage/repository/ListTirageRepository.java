package com.odc.FreeTirage.repository;

import com.odc.FreeTirage.model.ListeTirage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ListTirageRepository extends JpaRepository<ListeTirage, Long> {
}
