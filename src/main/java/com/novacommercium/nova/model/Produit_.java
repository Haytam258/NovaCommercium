package com.novacommercium.nova.model;


import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import java.util.List;

@StaticMetamodel(Produit.class)
public class Produit_ {

    public static volatile SingularAttribute<Produit, Integer> id;
    public static volatile SingularAttribute<Produit, String> name;
    public static volatile SingularAttribute<Produit, String> description;
    public static volatile SingularAttribute<Produit, Double> prix;
    public static volatile SingularAttribute<Produit, Integer> unite;
    public static volatile ListAttribute<Produit, MatierePremiere> matierePremiereList;
    public static volatile ListAttribute<Produit, Origine> origineList;

}
