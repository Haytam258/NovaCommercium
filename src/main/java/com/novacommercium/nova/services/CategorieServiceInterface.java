package com.novacommercium.nova.services;

import com.novacommercium.nova.model.Categorie;
import org.springframework.stereotype.Service;


public interface CategorieServiceInterface {

    public Categorie getCategorieById(int id);
}
