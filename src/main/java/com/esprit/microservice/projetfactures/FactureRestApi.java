package com.esprit.microservice.projetfactures;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/factures")
public class FactureRestApi {
    @Autowired
    //private FactureService factureService;

        private final IFactureService factureService ;
    private String title="Hello, I'm ibtihel chebbah second version ";
    @RequestMapping("/hello")
    public String sayhello() {
        return title;
    }
        @PostMapping("/ajoutefacture")
        public Facture addNewFacture (@RequestBody Facture facture){
            return factureService.addNewFacture(facture);
        }

        @PutMapping("/updateFacture/{idF}")
        public Facture updateFacture (@PathVariable("idF")  long idF , @RequestBody  Facture facture){
            facture.setIdF(idF);
            return factureService.updateFacture(facture);    }

        @DeleteMapping("/DeleteFacture/{idF}")
        public void SupprimerFacture(@PathVariable ("idF") long idF){
            factureService.deleteFacture(idF);
        }

        @GetMapping("/GetFactureById/{id}")
        public Facture getFactureById (@PathVariable ("idF") long idF){
            return   factureService.getFactureById(idF);
        }
        @GetMapping("/GetAllFacture")
        public List<Facture> getAllFacture(){
            return factureService.getAllFacture();
        }


    /**
     * Endpoint to calculate the total amount of all factures.
     * @return The total amount as a float.
     */
    @GetMapping("/total-amount")
    public float calculateTotalAmount() {
        return factureService.calculateTotalAmount();
    }
    }

