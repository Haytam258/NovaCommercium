package com.novacommercium.nova.specifications;

import com.novacommercium.nova.model.*;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.CollectionUtils;

import javax.persistence.criteria.Join;
import java.util.List;
import java.util.Set;

public final class ProduitSpecification {

    public static Specification<Produit> origineIn(Set<String> origines){
        if(CollectionUtils.isEmpty(origines)){
            return null;
        }
        return (root, query, builder) -> {
            Join<Produit, List<Origine>> produitOrigineJoin = root.join(String.valueOf(Produit_.origineList));
            return produitOrigineJoin.get(String.valueOf(Origine_.endroit)).in(origines);
        };
    }

    public static Specification<Produit> createProduitSpecifications(ProduitSearchCriteria searchCriteria) {
        return origineIn(searchCriteria.getOrigineList());
    }
}
