package com.novacommercium.nova.repositories;

import com.novacommercium.nova.model.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProduitRepoInterface extends JpaRepository<Produit, Integer> {

    @Query(value = "SELECT p FROM Produit p WHERE p.name= :name")
    public Produit getProductByName(@Param("name") String name);


}
