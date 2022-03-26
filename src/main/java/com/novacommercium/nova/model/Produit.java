package com.novacommercium.nova.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

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

}
