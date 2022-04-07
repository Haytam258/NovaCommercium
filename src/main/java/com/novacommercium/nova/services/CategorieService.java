package com.novacommercium.nova.services;


import com.novacommercium.nova.model.Categorie;
import com.novacommercium.nova.repositories.CategorieRepoInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategorieService implements CategorieServiceInterface {

    private final CategorieRepoInterface categorieRepo;

    @Autowired
    public CategorieService(CategorieRepoInterface categorieRepo){
        this.categorieRepo = categorieRepo;
    }

    public Categorie getCategorieById(int id){
        return categorieRepo.findById(id).get();
    }
}
