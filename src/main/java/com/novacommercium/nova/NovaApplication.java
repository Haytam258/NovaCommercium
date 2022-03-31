package com.novacommercium.nova;

import com.novacommercium.nova.model.MatierePremiere;
import com.novacommercium.nova.model.Produit;
import com.novacommercium.nova.repositories.MatierePreRepoInterface;
import com.novacommercium.nova.repositories.ProduitRepoInterface;
import com.novacommercium.nova.services.MatiereServiceInterface;
import com.novacommercium.nova.services.ProduitServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NovaApplication {





    /*Faire les controllers en forme de REST, AOP logging spécialement des fonctions qui font les Select,
    * Implementer Spring security, les services n'ont que des fonctionnalités simples, donc pas la peine
    * d'ajouter plus de fonctionnalités. */


    public static void main(String[] args) {
        SpringApplication.run(NovaApplication.class, args);
    }


}
