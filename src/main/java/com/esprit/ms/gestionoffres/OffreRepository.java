package com.esprit.ms.gestionoffres;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface OffreRepository extends JpaRepository<Offre, Long> {

    @Query("select o from Offre  o where o.titre like :titre")
    public Page<Offre> offreByTitre(@Param("titre") String n , Pageable pageable);
}
