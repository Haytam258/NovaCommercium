package com.novacommercium.nova.model;


import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import java.util.List;

@StaticMetamodel(Origine.class)
public class Origine_ {

    public static volatile SingularAttribute<Origine, Integer> id;
    public static volatile SingularAttribute<Origine, String> endroit;
    public static volatile SingularAttribute<Origine, List<Produit>> produitList;
    public static volatile SingularAttribute<Origine, List<MatierePremiere>> matierePremiereList;
}
