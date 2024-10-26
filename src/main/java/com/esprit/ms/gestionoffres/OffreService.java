package com.esprit.ms.gestionoffres;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OffreService implements IOffreService {

    @Autowired
    private OffreRepository offreRepository;

    // Create an offer
    @Override
    public Offre saveOffre(Offre offre) {
        return offreRepository.save(offre);
    }

    // Read an offer by ID
    @Override
    public Offre getOffreById(Long id) {
        Optional<Offre> offre = offreRepository.findById(id);
        return offre.orElseThrow(() -> new RuntimeException("Offre not found with id: " + id));
    }

    // Read all offers
    @Override
    public List<Offre> getAllOffres() {
        return offreRepository.findAll();
    }

    // Update an offer
    @Override
    public Offre updateOffre(Long id, Offre updatedOffre) {
        Optional<Offre> existingOffreOpt = offreRepository.findById(id);
        if (existingOffreOpt.isPresent()) {
            Offre existingOffre = existingOffreOpt.get();
            existingOffre.setTitre(updatedOffre.getTitre());
            existingOffre.setDescription(updatedOffre.getDescription());
            existingOffre.setPrix(updatedOffre.getPrix());
            existingOffre.setDateDebut(updatedOffre.getDateDebut());
            existingOffre.setDateFin(updatedOffre.getDateFin());
            return offreRepository.save(existingOffre);
        } else {
            throw new RuntimeException("Offre not found with id: " + id);
        }
    }

    // Delete an offer by ID
    @Override
    public void deleteOffre(Long id) {
        offreRepository.deleteById(id);
    }


}
