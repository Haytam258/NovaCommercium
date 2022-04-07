package com.novacommercium.nova.rest;


import com.novacommercium.nova.model.Produit;
import com.novacommercium.nova.services.CooperativeServiceInterface;
import com.novacommercium.nova.services.ProduitServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CooperativeController {

    private final CooperativeServiceInterface cooperativeService;

    private final ProduitServiceInterface produitService;

    @Autowired
    public CooperativeController(CooperativeServiceInterface cooperativeService, ProduitServiceInterface produitService){
        this.cooperativeService = cooperativeService;
        this.produitService = produitService;
    }

    @GetMapping("/products/cooperative/{id}")
    public List<Produit> getProductsByCooperative(@PathVariable Long id){
        return produitService.getProductsByCooperative(cooperativeService.getCooperativeById(Math.toIntExact(id)));
    }
}
