package com.novacommercium.nova.rest;


import com.novacommercium.nova.model.Categorie;
import com.novacommercium.nova.model.Produit;
import com.novacommercium.nova.services.CategorieServiceInterface;
import com.novacommercium.nova.services.ProduitService;
import com.novacommercium.nova.services.ProduitServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategorieController {

    private final ProduitServiceInterface produitService;

    private final CategorieServiceInterface categorieService;

    @Autowired
    public CategorieController(ProduitServiceInterface produitService, CategorieServiceInterface categorieService){
        this.categorieService = categorieService;
        this.produitService = produitService;
    }

    @GetMapping(value = "/products/category/{id}")
    public List<Produit> getProductsByCategorie(@PathVariable Long id){
        return produitService.getProductsByCategorie(categorieService.getCategorieById(Math.toIntExact(id)));
    }
}
