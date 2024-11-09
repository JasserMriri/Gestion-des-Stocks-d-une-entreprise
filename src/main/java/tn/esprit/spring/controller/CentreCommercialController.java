package tn.esprit.spring.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.entitities.CentreCommercial;
import tn.esprit.spring.services.IServiceCentreService;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/Centre")
@RestController
public class CentreCommercialController {
    private final IServiceCentreService iServiceCentre ;
    @PostMapping("/ajouteCentre")
    public CentreCommercial ajouterCentre (@RequestBody CentreCommercial centre){
        return iServiceCentre.ajouterCentre(centre);
    }

    @PutMapping("/updateCentre/{id}")
    public CentreCommercial updateCentre (@PathVariable("id")  long id , @RequestBody  CentreCommercial centre){
        centre.setIdCentre(id);
        return iServiceCentre.updateCentre(centre);    }

    @DeleteMapping("/DeleteCentre/{idCentre}")
    public void SupprimerCentre(@PathVariable ("idCentre") long idCentre){
        iServiceCentre.SupprimerCentre(idCentre);
    }

    @GetMapping("/GetCentreById/{id}")
    public CentreCommercial getCentreById (@PathVariable ("id") long idCentre){
        return   iServiceCentre.getCentreById(idCentre);
    }
    @GetMapping("/GetAllCentre")
    public List<CentreCommercial> getAllCentre(){
        return iServiceCentre.getAllCentre();
    }
}
