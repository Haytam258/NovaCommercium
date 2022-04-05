package com.novacommercium.nova.repositories;

import com.novacommercium.nova.model.Origine;
import com.novacommercium.nova.model.Produit;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Set;

public class ProduitRepoCustomImple implements ProduitRepoCustomInterface{

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Produit> findProduitByOrigines(Set<Origine> origines) {
        /*CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Produit> query = cb.createQuery(Produit.class);
        Root<Produit> produit = query.from(Produit.class);
        Path<Origine> */
        return null;

    }
}
