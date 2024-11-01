package com.esprit.microservice.projetfactures;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public  class FactureService  implements  IFactureService {
    @Autowired
    private  FactureRepository factureRepository ;

    @Override
    public Facture addNewFacture(Facture facture) {
        return factureRepository.save(facture);
    }

    @Override
    public Facture updateFacture(Facture facture) {
        return factureRepository.save(facture);
    }


    @Override
    public void deleteFacture(long idF) {
        factureRepository.deleteById(idF);

    }

    @Override
    public Facture getFactureById(long idF) {
        return factureRepository.getById(idF);
    }

    @Override
    public List<Facture> getAllFacture() {
        return factureRepository.findAll();
    }

    @Override
    public float calculateTotalAmount() {
        List<Facture> factures = factureRepository.findAll();
        return factures.stream()
                .map(facture -> facture.getPrix() * facture.getQuantite())
                .reduce(0.0f, Float::sum);
    }


}
