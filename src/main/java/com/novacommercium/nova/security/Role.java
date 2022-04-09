package com.novacommercium.nova.security;


import lombok.Data;

import javax.persistence.*;

//S'agit de la table des roles, dont l'énumération sont les valeurs précisées dans GeneralRole et qui doivent etre les memes que ceux de la base de données
// c'est-à-dire, sur MySQL, la colonne roles avec enum('ADMIN','CLIENT','UTILISATEUR') doit etre la meme que les valeurs dans GeneralRole.
//En quelque sorte, Role accède à la base de données et GeneralRole se focalise plus sur l'application.
@Entity
@Data
@Table(name= "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Enumerated(EnumType.STRING)
    private GeneralRole roles;
}
