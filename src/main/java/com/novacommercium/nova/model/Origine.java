package com.novacommercium.nova.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor @ToString
@Table(name="origine")
public class Origine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "endroit")
    private String endroit;

    @ManyToMany
    @JoinTable(name="origine_produit",
    joinColumns = @JoinColumn(name = "origine_id"),
    inverseJoinColumns = @JoinColumn(name="produit_id"))
    public List<Produit> produitList;

    @ManyToMany
    @JoinTable(name="origine_matiere",
    joinColumns = @JoinColumn(name="origine_id"),
    inverseJoinColumns = @JoinColumn(name = "matiere_id"))
    private List<MatierePremiere> matierePremiereList;

}
