package com.example.boutiquemicroservice.Repository;
import com.example.boutiquemicroservice.Entity.Boutique;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
public interface IBoutiqueRepo extends JpaRepository<Boutique , Long> {

}
