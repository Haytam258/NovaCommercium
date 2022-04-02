package com.novacommercium.nova.services;


import com.novacommercium.nova.model.MatierePremiere;
import com.novacommercium.nova.model.Origine;
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
        productRepo.saveAndFlush(product);
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

    public Produit updateProduct(int id, Produit product){
        Produit prod = productRepo.findById(id).get();
        prod.setName(product.getName());
        prod.setPrix(product.getPrix());
        prod.setDescription(product.getDescription());
        prod.setUnite(product.getUnite());
        return prod;
    }

    public Produit getProductThroughName(String name){
        Produit product = productRepo.findProduitByName(name);
        return product;
    }

    public List<Produit> getAllProducts(){
        return productRepo.findAll();
    }
    public Produit getProductById(int id){
        return productRepo.findById(id).get();
    }

    /*public List<Produit> getProductsByMatiereList(List<MatierePremiere> matierePremiereList){
        return productRepo.getProduitsByMatierePremiereList(matierePremiereList);
    }

    public Produit getProductByMatiereList(List<MatierePremiere> matierePremiereList){
        return productRepo.getProduitByMatierePremiereList(matierePremiereList);
    }
 */
    public void addMatiereToProduit(Produit produit,MatierePremiere matierePremiere){
        produit.addMatierePremiere(matierePremiere);
        productRepo.saveAndFlush(produit);
    }

    public void addOrigineToProduit(Produit produit, Origine origine){
        produit.addOrigine(origine);
        productRepo.saveAndFlush(produit);
    }


}
