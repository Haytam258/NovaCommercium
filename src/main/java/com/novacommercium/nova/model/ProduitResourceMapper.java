package com.novacommercium.nova.model;


import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ProduitResourceMapper {

    ProduitResourceMapper INSTANCE = Mappers.getMapper(ProduitResourceMapper.class);

    ProduitResource map(Produit produit);
    List<ProduitResource> map(List<Produit> produitList);
}
