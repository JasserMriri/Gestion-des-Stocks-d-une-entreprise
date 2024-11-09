package com.esprit.prodouih;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProduitService {

    @Autowired
    private ProduitRepository produitRepository;

    // Add a product
    public Produit addProduit(Produit produit) {
        return produitRepository.save(produit);
    }

    // Get all products
    public List<Produit> getAll() {
        return produitRepository.findAll();
    }

    // Update a product
    public Produit updateProduit(Produit produit) {
        return produitRepository.save(produit);
    }

    // Delete a product by ID
    public void deleteProduit(Long idProduit) { // Changed int to Long
        produitRepository.deleteById(idProduit);
    }
}
