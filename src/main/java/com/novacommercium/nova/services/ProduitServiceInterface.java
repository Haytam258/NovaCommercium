package com.novacommercium.nova.services;

import com.novacommercium.nova.model.*;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ProduitServiceInterface {

    public void deleteProductById(int id);
    public void deleteProduct(Produit product);
    public void createProduct(Produit product);
    public void modifyProduct(Produit product, String name, String description, double prix, int unite);
    public Produit getProductThroughName(String name);
    public List<Produit> getAllProducts();
    public Produit getProductById(int id);
    public Produit getProductByMatiereList(List<MatierePremiere> matierePremiereList);
    public List<Produit> getProductsByMatiereList(List<MatierePremiere> matierePremiereList);
    public Produit addMatiereToProduit(int id,MatierePremiere matierePremiere);
    public void addOrigineToProduit(Produit produit, Origine origine);
    public Produit updateProduct(int id, Produit product);
    public Produit addExisitingMatiereToProduit(int idp, int idm);
    public List<Produit> getProductsByCategorie(Categorie categorie);
    public List<Produit> getProductsByCooperative(Cooperative cooperative);
    public List<Produit> getProductsFromMatiereUniqueFunction(List<Integer> ids);
    public List<Produit> getProductsFromOrigineUniqueFunction(List<Integer> ids);

}
