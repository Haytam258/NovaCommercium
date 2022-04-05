package com.novacommercium.nova.repositories;

import com.novacommercium.nova.model.Origine;
import com.novacommercium.nova.model.Produit;

import java.util.List;
import java.util.Set;

public interface ProduitRepoCustomInterface {
    public List<Produit> findProduitByOrigines(Set<Origine> origines);
}
