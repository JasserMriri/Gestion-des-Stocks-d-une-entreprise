package com.esprit.prodouih;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produits")
public class ProduitRestAPI {

    @Autowired
    private ProduitService produitService;

    // Adding a product
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/ajouterProduit")
    public Produit addProduit(@RequestBody Produit produit) {
        return produitService.addProduit(produit);
    }

    // Fetching all products
    @GetMapping("/getAllProduit")
    public List<Produit> getAll() {
        return produitService.getAll();
    }

    // Updating a product by ID
    @PutMapping("/updateProduit/{idProduit}")
    public Produit updateProduit(@PathVariable("idProduit") Long idProduit, @RequestBody Produit produit) { // Changed int to Long
        produit.setIdProduit(idProduit);
        return produitService.updateProduit(produit);
    }

    // Deleting a product by ID
    @DeleteMapping("/deleteProduit/{idProduit}")
    public void deleteProduit(@PathVariable("idProduit") Long idProduit) { // Changed int to Long
        produitService.deleteProduit(idProduit);
    }
}
