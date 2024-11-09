package com.example.boutiquemicroservice.Controller;


import com.example.boutiquemicroservice.Entity.Boutique;
import com.example.boutiquemicroservice.Service.IBoutiqueService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/Boutique")
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class BoutiqueControlleur {
    private final IBoutiqueService iBoutiqueService ;

    @PostMapping("/AjouterBoutique")
    public Boutique ajouterBoutique (@RequestBody Boutique boutique){
        return iBoutiqueService.ajouterBoutique(boutique);
    }
    @PostMapping("/updateBoutique/{idBoutique}")
    public Boutique updateBoutique (@PathVariable ("idBoutique")long idBoutique ,@RequestBody Boutique boutique){
        return iBoutiqueService.updateBoutique(boutique);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteBoutique (@PathVariable ("id")long id ){
        iBoutiqueService.deleteBoutique(id);
    }

    @GetMapping("/GetBoutiqueById/{id}")
    public Boutique getBoutiqueById (@PathVariable ("id") long idB){
        return iBoutiqueService.getBoutiqueById(idB);
    }

    @GetMapping("/GetAllBoutique")
    public List<Boutique> getAllBoutique(){
        return iBoutiqueService.getAllBoutique();
    }
}
