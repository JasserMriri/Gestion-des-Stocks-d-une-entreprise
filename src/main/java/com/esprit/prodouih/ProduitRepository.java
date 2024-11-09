package com.esprit.prodouih;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProduitRepository extends JpaRepository<Produit, Long> { // Changed Integer to Long

   /* @Query("select p from Produit p where p.nomP like %:name%")
    public Page<Produit> produitByNomP(@Param("name") String name, Pageable pageable);*/
}
