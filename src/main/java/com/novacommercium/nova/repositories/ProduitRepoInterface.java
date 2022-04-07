package com.novacommercium.nova.repositories;

import com.novacommercium.nova.model.*;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.lang.Nullable;

import java.util.List;

public interface ProduitRepoInterface extends JpaRepository<Produit, Integer>, JpaSpecificationExecutor<Produit> {

    public Produit findProduitByName(String name);
    public List<Produit> findDistinctProduitsByMatierePremiereListIn(List<MatierePremiere> matierePremiereList);
    public Produit findDistinctProduitByMatierePremiereListIn(List<MatierePremiere> matierePremiereList);
    public List<Produit> findProduitsByCategorie(Categorie categorie);
    public List<Produit> findProduitsByCooperative(Cooperative cooperative);

   /* @EntityGraph(type = EntityGraph.EntityGraphType.FETCH, attributePaths = {
            "origineList"
    })
    public List<Produit> findProduitsByOrigineList(@Nullable Specification<Origine> spec);

    @Query(value = "SELECT p.* FROM produit p JOIN produit_matiere pm ON\n" +
            "pm.produit_id = p.id JOIN matiere_premiere m ON m.id = pm.matiere_id\n" +
            "WHERE m.id IN (1,2) HAVING COUNT(DISTINCT m.id) = 2",nativeQuery = true)*/


}
