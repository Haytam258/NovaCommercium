package com.novacommercium.nova.model;

import lombok.Data;

import java.util.List;


@Data
public class ProduitResource {
    private int id;


    private String name;


    private String description;


    private double prix;


    private int unite;

    private List<Origine> origineList;
    private List<MatierePremiere> matierePremiereList;

}
