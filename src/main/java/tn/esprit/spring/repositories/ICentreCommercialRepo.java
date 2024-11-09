package tn.esprit.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.spring.entitities.CentreCommercial;

import java.util.List;
@Repository
public interface ICentreCommercialRepo extends JpaRepository<CentreCommercial, Long> {


}
