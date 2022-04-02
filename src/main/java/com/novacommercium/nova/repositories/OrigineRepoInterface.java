package com.novacommercium.nova.repositories;

import com.novacommercium.nova.model.MatierePremiere;
import com.novacommercium.nova.model.Origine;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrigineRepoInterface extends JpaRepository<Origine, Integer> {

    public Origine findOrigineByEndroit(String endroit);
    /*public List<Origine> getOriginesByMatierePremiereList(List<MatierePremiere> matierePremiereList);
    public Origine getOrigineByMatierePremiereList(List<MatierePremiere> matierePremiereList);*/
}
