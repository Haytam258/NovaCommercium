package com.novacommercium.nova.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
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

    //Added JsonManagedReference and JsonBackReference to avoid JSON Infinite recursion, i could also delete matierePremiereList
    //and produitList as well but this is helpful in its own way.

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "endroit")
    private String endroit;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="origine_produit",
    joinColumns = @JoinColumn(name = "origine_id"),
    inverseJoinColumns = @JoinColumn(name="produit_id"))
    @JsonBackReference
    public List<Produit> produitList;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="origine_matiere",
    joinColumns = @JoinColumn(name="origine_id"),
    inverseJoinColumns = @JoinColumn(name = "matiere_id"))
    @JsonBackReference
    private List<MatierePremiere> matierePremiereList;

}
