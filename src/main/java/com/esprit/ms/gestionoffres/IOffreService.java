package com.esprit.ms.gestionoffres;

import java.util.List;

public interface IOffreService {

    // Create an offer
    Offre saveOffre(Offre offre);

    // Read an offer by ID
    Offre getOffreById(Long id);

    // Read all offers
    List<Offre> getAllOffres();

    // Update an offer
    Offre updateOffre(Long id, Offre offre);

    // Delete an offer by ID
    void deleteOffre(Long id);


}
