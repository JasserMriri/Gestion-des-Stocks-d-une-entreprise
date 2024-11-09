package tn.esprit.spring.services;

import tn.esprit.spring.entitities.CentreCommercial;

import java.util.List;

public interface IServiceCentreService {
    public CentreCommercial ajouterCentre (CentreCommercial centre);
    public CentreCommercial updateCentre (CentreCommercial centre);

    public void SupprimerCentre(long idCentre);

    public CentreCommercial getCentreById (long idCentre);

    public List<CentreCommercial> getAllCentre();
}
