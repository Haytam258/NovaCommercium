package com.novacommercium.nova.services;


import com.novacommercium.nova.model.Produit;
import com.novacommercium.nova.repositories.ProduitRepoInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProduitService implements ProduitServiceInterface {

    private final ProduitRepoInterface productRepo;

    @Autowired
    public ProduitService(ProduitRepoInterface productRepo){
        this.productRepo = productRepo;
    }

    public void createProduct(Produit product){
        productRepo.save(product);
    }

    public void deleteProduct(Produit product){
        productRepo.delete(product);
    }

    public void deleteProductById(int id){
        productRepo.deleteById(id);
    }

    public void modifyProduct(Produit product, String name, String description, double prix, int unite){
        product.setName(name);
        product.setId(product.getId());
        product.setDescription(description);
        product.setUnite(unite);
        product.setPrix(prix);
        productRepo.saveAndFlush(product);
    }

    public Produit getProductThroughName(String name){
        Produit product = productRepo.getProductByName(name);
        return product;
    }

    public List<Produit> getAllProducts(){
        return productRepo.findAll();
    }
}
