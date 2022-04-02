package com.novacommercium.nova.repositories;

import com.novacommercium.nova.model.MatierePremiere;
import com.novacommercium.nova.model.Origine;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrigineRepoInterface extends JpaRepository<Origine, Integer> {

    public Origine findOrigineByEndroit(String endroit);
    //Need to add "in" at the end, otherwise it's not valid in JPA
    public List<Origine> findOriginesByMatierePremiereListIn(List<MatierePremiere> matierePremiereList);
    public Origine findOrigineByMatierePremiereListIn(List<MatierePremiere> matierePremiereList);
}
