package com.novacommercium.nova.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor @ToString
@Table(name="cooperative")
public class Cooperative {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    @Column(name="name")
    private String nom;

    @Column(name="numero_de_tel")
    private int numeroDeTel;

    @OneToMany(mappedBy = "cooperative")
    @JsonBackReference
    private List<Produit> produitList;

    public void add(Produit produit){
        if(produitList == null){
            this.produitList = new ArrayList<>();
        }
        produitList.add(produit);
    }
}
