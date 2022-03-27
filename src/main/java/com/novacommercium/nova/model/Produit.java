package com.novacommercium.nova.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="produit")
@Data @AllArgsConstructor @NoArgsConstructor @ToString
public class Produit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="name")
    private String name;

    @Column(name="description")
    private String description;

    @Column(name="prix")
    private double prix;

    @Column(name="unite")
    private int unite;

    @ManyToMany
    @JoinTable(name = "origine_produit",
    joinColumns =@JoinColumn(name="produit_id"),
    inverseJoinColumns = @JoinColumn(name="origine_id"))
    private List<Origine> origineList;

    @ManyToMany
    @JoinTable(name = "produit_matiere",
    joinColumns = @JoinColumn(name ="produit_id"),
    inverseJoinColumns = @JoinColumn(name="matiere_id"))
    private List<MatierePremiere> matierePremiereList;

    public void addMatierePremiere(MatierePremiere matierePremiere){
        if(matierePremiereList == null){
            matierePremiereList = new ArrayList<>();
        }

        matierePremiereList.add(matierePremiere);
    }

    public void addOrigine(Origine origine){
        if(origineList == null){
            origineList = new ArrayList<>();
        }

        origineList.add(origine);
    }
}
