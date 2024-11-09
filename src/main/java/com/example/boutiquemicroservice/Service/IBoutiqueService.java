package com.example.boutiquemicroservice.Service;

import com.example.boutiquemicroservice.Entity.Boutique;

import java.util.List;

public interface IBoutiqueService {
    public Boutique ajouterBoutique ( Boutique boutique);
    public Boutique updateBoutique (Boutique boutique);


    public Boutique getBoutiqueById (long idB);

    public List<Boutique> getAllBoutique();




    public void deleteBoutique (long id );

}
