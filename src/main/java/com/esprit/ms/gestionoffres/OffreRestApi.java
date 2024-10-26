package com.esprit.ms.gestionoffres;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/offres")
public class OffreRestApi {

    @Autowired
    private OffreService offreService;
    private OffreRepository offreRepository;

    // Say Hello example
    private String title = "hello world ms 5sae3";

    @RequestMapping("/hello")
    public String sayHello() {
        return title;
    }

    // Get all offers
    @GetMapping
    public List<Offre> getAllOffres() {
        return offreService.getAllOffres();
    }

    // Get offer by ID
    @GetMapping("/{id}")
    public Offre getOffreById(@PathVariable Long id) {
        return offreService.getOffreById(id);
    }

    // Create a new offer
    @PostMapping
    public Offre createOffre(@RequestBody Offre offre) {
        return offreService.saveOffre(offre);
    }

    // Update an existing offer
    @PutMapping("/{id}")
    public Offre updateOffre(@PathVariable Long id, @RequestBody Offre offre) {
        return offreService.updateOffre(id, offre);
    }

    // Delete an offer
    @DeleteMapping("/{id}")
    public void deleteOffre(@PathVariable Long id) {
        offreService.deleteOffre(id);
    }

    @GetMapping("/search")
    public Page<Offre> searchOffreByTitre(@RequestParam String titre, Pageable pageable) {
        Page<Offre> result = offreRepository.offreByTitre(titre, pageable);

        if (result.isEmpty()) {
            throw new RuntimeException("Offre not found with title: " + titre);
        }

        return result;
    }


}


