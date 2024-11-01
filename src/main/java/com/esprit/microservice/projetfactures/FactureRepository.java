package com.esprit.microservice.projetfactures;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface FactureRepository extends JpaRepository<Facture, Long> {
    @Query("select f from Facture f where f.code like :code")
    public Page<Facture> factureBycode(@Param("code") String n, Pageable pageable);
}
