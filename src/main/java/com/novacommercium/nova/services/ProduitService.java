package com.novacommercium.nova.services;


import com.novacommercium.nova.model.*;
import com.novacommercium.nova.repositories.CategorieRepoInterface;
import com.novacommercium.nova.repositories.MatierePreRepoInterface;
import com.novacommercium.nova.repositories.ProduitRepoInterface;
import com.novacommercium.nova.specifications.ProduitSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class ProduitService implements ProduitServiceInterface {

    private final ProduitRepoInterface productRepo;

    private final MatierePreRepoInterface matiereRepo;

    private final CategorieRepoInterface categorieRepo;

    private final MatiereServiceInterface matiereService;

    private final OrigineServiceInterface origineService;

    @Autowired
    public ProduitService(ProduitRepoInterface productRepo, MatierePreRepoInterface matiereRepo, CategorieRepoInterface categorieRepo, MatiereServiceInterface matiereService, OrigineServiceInterface origineService){
        this.matiereRepo = matiereRepo;
        this.productRepo = productRepo;
        this.categorieRepo = categorieRepo;
        this.matiereService = matiereService;
        this.origineService = origineService;
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
        productRepo.saveAndFlush(prod);
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

    public List<Produit> getProductsByMatiereList(List<MatierePremiere> matierePremiereList){
        return productRepo.findDistinctProduitsByMatierePremiereListIn(matierePremiereList);
    }

    public Produit getProductByMatiereList(List<MatierePremiere> matierePremiereList){
        return productRepo.findDistinctProduitByMatierePremiereListIn(matierePremiereList);
    }
    public Produit addMatiereToProduit(int id,MatierePremiere matierePremiere){
        Produit produit = productRepo.findById(id).get();
        produit.addMatierePremiere(matierePremiere);
        productRepo.saveAndFlush(produit);
        return produit;
    }

    public void addOrigineToProduit(Produit produit, Origine origine){
        produit.addOrigine(origine);
        productRepo.saveAndFlush(produit);
    }

    public Produit addExisitingMatiereToProduit(int idp, int idm){
        MatierePremiere mat = matiereRepo.findById(idm).get();
        Produit prod = productRepo.findById(idp).get();
        prod.getMatierePremiereList().add(mat);
        return prod;
    }

    public List<Produit> retrieveProducts(ProduitSearchCriteria searchCriteria){
        Specification<Produit> produitSpecification = ProduitSpecification.createProduitSpecifications(searchCriteria);
        return productRepo.findAll(produitSpecification);
    }

    public List<Produit> getProductsByCategorie(Categorie categorie){
        return productRepo.findProduitsByCategorie(categorie);
    }

    public List<Produit> getProductsByCooperative(Cooperative cooperative) {
        return productRepo.findProduitsByCooperative(cooperative);
    }

    public List<Produit> getProductsFromMatiereUniqueFunction(List<Integer> ids){
        List<MatierePremiere> matierePremiereList = new ArrayList<>();
        for (Integer id: ids) {
            matierePremiereList.add(matiereService.getMatiereById(id));
        }
        List<Produit> produitList  = getProductsByMatiereList(matierePremiereList);
        for(Iterator<Produit> produitIterator = produitList.iterator(); produitIterator.hasNext();){
            Produit produit = produitIterator.next();
            if(produit.getMatierePremiereList().size() != ids.size()){
                produitIterator.remove();
            }
            else {
                for(Iterator<MatierePremiere> matierePremiereIterator = produit.getMatierePremiereList().iterator(); matierePremiereIterator.hasNext();){
                    MatierePremiere matierePremiere = matierePremiereIterator.next();
                    if(!(ids.contains(matierePremiere.getId()))){
                        produitIterator.remove();
                    }
                }
            }

        }
        return produitList;
    }

    public List<Produit> getProductsFromOrigineUniqueFunction(List<Integer> ids){
        List<Origine> origineList = new ArrayList<>();
        for (Integer id : ids){
            origineList.add(origineService.getOrigineById(id));
        }
        List<MatierePremiere> matierePremiereList = matiereService.getMatieresByOrigineList(origineList);
        //Itération sur la liste des matières premières pour éliminer les matières premières n'ayant pas une liste d'ogirines de tailles = ids.size()
        for(Iterator<MatierePremiere> matierePremiereIterator = matierePremiereList.iterator(); matierePremiereIterator.hasNext();){
            MatierePremiere matierePremiere = matierePremiereIterator.next();
            if(matierePremiere.getOrigineList().size() != ids.size()){
                matierePremiereIterator.remove();
            }
            //Itération sur l'origine de chaque OrigineList de la matière première pour éliminer les matières premières n'ayant pas une certaine origine spécifiée.
            else {
                for(Iterator<Origine> origineIterator = matierePremiere.getOrigineList().iterator(); origineIterator.hasNext();){
                    Origine origine = origineIterator.next();
                    if(!(ids.contains(origine.getId()))){
                        matierePremiereIterator.remove();
                    }
                }
            }

        }
        return getProductsByMatiereList(matierePremiereList);
    }



}
