package com.novacommercium.nova.services;

import com.novacommercium.nova.model.Produit;

public interface ProduitServiceInterface {

    public void deleteProductById(int id);
    public void deleteProduct(Produit product);
    public void createProduct(Produit product);
    public void modifyProduct(Produit product, String name, String description, double prix, int unite);
    public Produit getProductThroughName(String name);
}
