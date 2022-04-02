package com.novacommercium.nova.repositories;

import com.novacommercium.nova.model.MatierePremiere;
import com.novacommercium.nova.model.Origine;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MatierePreRepoInterface extends JpaRepository<MatierePremiere, Integer> {

    public MatierePremiere findByName(String name);
    /*public MatierePremiere getMatierePremiereByOrigineList(List<Origine> origineList);
    public List<MatierePremiere> getMatierePremieresByOrigineList(List<Origine> origineList);*/
}
