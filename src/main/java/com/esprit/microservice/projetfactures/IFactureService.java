package com.esprit.microservice.projetfactures;

import java.util.List;

public interface IFactureService {
    Facture addNewFacture(Facture facture);
    public Facture updateFacture(Facture facture);

    public void deleteFacture(long idF);
    public Facture getFactureById(long idF);
    public List<Facture> getAllFacture();


    /**
     * Calculate the total amount (prix * quantite) of all factures.
     * @return The total amount of all factures.
     */
    float calculateTotalAmount();

}
