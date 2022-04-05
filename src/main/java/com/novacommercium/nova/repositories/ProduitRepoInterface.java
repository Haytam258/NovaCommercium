package com.novacommercium.nova.repositories;

import com.novacommercium.nova.model.MatierePremiere;
import com.novacommercium.nova.model.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProduitRepoInterface extends JpaRepository<Produit, Integer> {

    public Produit findProduitByName(String name);
    public List<Produit> findDistinctProduitsByMatierePremiereListIn(List<MatierePremiere> matierePremiereList);
    public Produit findDistinctProduitByMatierePremiereListIn(List<MatierePremiere> matierePremiereList);

}
