package tn.esprit.spring.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.spring.entitities.CentreCommercial;
import tn.esprit.spring.repositories.ICentreCommercialRepo;

import java.util.List;
@Service
@AllArgsConstructor

public class CentreCommercialServiceImplements implements IServiceCentreService{
    private  ICentreCommercialRepo iCentreCommercialRepo ;
    @Override
    public CentreCommercial ajouterCentre(CentreCommercial centre) {
        return iCentreCommercialRepo.save(centre); }

    @Override
    public CentreCommercial updateCentre(CentreCommercial centre) {
        return iCentreCommercialRepo.save(centre);

    }

    @Override
    public void SupprimerCentre(long idCentre) {
        iCentreCommercialRepo.deleteById(idCentre);
    }

    @Override
    public CentreCommercial getCentreById(long idCentre) {
        return iCentreCommercialRepo.getById(idCentre);
    }

    @Override
    public List<CentreCommercial> getAllCentre() {
        return iCentreCommercialRepo.findAll();    }
}
