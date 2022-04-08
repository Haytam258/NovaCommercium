package com.novacommercium.nova.rest;


import com.novacommercium.nova.model.*;
import com.novacommercium.nova.services.MatiereServiceInterface;
import com.novacommercium.nova.services.OrigineServiceInterface;
import com.novacommercium.nova.services.ProduitServiceInterface;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

@RestController
public class ProduitController {

    //RIP Single responsability principle :(

    private final ProduitServiceInterface productService;

    private final MatiereServiceInterface matiereService;

    private final OrigineServiceInterface origineService;


    @Autowired
    public ProduitController(ProduitServiceInterface productService, MatiereServiceInterface matiereService, OrigineServiceInterface origineService ){
        this.productService = productService;
        this.matiereService = matiereService;
        this.origineService = origineService;
    }


    @GetMapping("/showProduct")
    public String showPageCreateProduct(Model model){
        model.addAttribute("newProduct", new Produit());
        return "createProduct";
    }

    @PostMapping("/createProduct")
    public void createProduct(@RequestBody Produit product){
        productService.createProduct(product);
    }

    @GetMapping("/productList")
    public List<Produit> productList(){
        return productService.getAllProducts();
    }

    @DeleteMapping("/deleteProduct")
    public void deleteProduct(@RequestParam Long id){
        productService.deleteProductById(Math.toIntExact(id));
    }

    @GetMapping("/product/{id}")
    public Produit getProduct(@PathVariable Long id){
        Produit product = productService.getProductById(Math.toIntExact(id));
        return product;
    }

    @PutMapping("/product/{id}")
    public Produit updateProduct(@PathVariable Long id, @RequestBody Produit product){
        return productService.updateProduct(Math.toIntExact(id), product);
    }

    //Obtenir le produit à partir de la matière première spécifiée sous forme d'objet dans JSON.
    @GetMapping("/productMatiere")
    public Produit getProduitFromMatiere(@RequestBody MatierePremiere matierePremiere){
        List<MatierePremiere> matList = new ArrayList<>();
        matList.add(matierePremiere);
        return productService.getProductByMatiereList(matList);
    }

    //Obtenir le produit à partir de l'id de la matière première spécifiée.
    @GetMapping("/productMatiereID/{id}")
    public Produit getProduitFromMatiereID(@PathVariable Long id){
        MatierePremiere mat = matiereService.getMatiereById(Math.toIntExact(id));
        List<MatierePremiere> matList = new ArrayList<>();
        matList.add(mat);
        return productService.getProductByMatiereList(matList);
    }

    //Ajouter une matière première déjà existante dans la base de données au produit.
    @PostMapping("/addMatiereProduct")
    public Produit addExistingMatiereToProduct(@RequestParam int idp, @RequestParam int idm){
        return productService.addExisitingMatiereToProduit(idp,idm);
    }

    //Permet de trouver les produits dont au moins 1 matière première appartient à la liste des ids spécifiées.
    @GetMapping(value = "/getProducts", params = "ids")
    public ResponseEntity<List<Produit>> getProductsFromMatiereIDS(@RequestParam List<Integer> ids){
        List<MatierePremiere> matList = new ArrayList<>();
        for (Integer id: ids) {
            matList.add(matiereService.getMatiereById(Math.toIntExact(id)));
        }
        return ResponseEntity.ok(productService.getProductsByMatiereList(matList));
    }

    //Fonctionne correctement, on précise une liste de matières premières en nom et elle va les chercher, au moins une matière doit figurer dans le produit.
    @GetMapping(value = "/products/", params = "matiere")
    public ResponseEntity<List<Produit>> getProductsFromMatiere(@RequestParam List<String> matiere){
        List<MatierePremiere> matList = new ArrayList<>();
        for( String mat : matiere){
            matList.add(matiereService.getMatiereByName(mat));
        }
        return ResponseEntity.ok(productService.getProductsByMatiereList(matList));
    }

    //Permet d'obtenir les produits à partir des ids des origines spécifiées, au moins 1 id et non pas tous les ids doivent figurer dans le produit.
    @GetMapping(value = "/products/matieres/origine", params = "ids")
    public List<Produit> getProductsFromOrigine(@RequestParam List<Integer> ids){
        List<Origine> origineList = new ArrayList<>();
        for (Integer id : ids){
            origineList.add(origineService.getOrigineById(id));
        }
        List<MatierePremiere> matierePremiereList = matiereService.getMatieresByOrigineList(origineList);
        return productService.getProductsByMatiereList(matierePremiereList);
    }

    //Permet d'obtenir les produits dont les origines des matières premières sont exactement ceux spécifiés dans les paramètres de HTTP à travers les id.
    @GetMapping(value = "/products/matieres/origines", params = "ids")
    public List<Produit> getProductsFromOrigineUnique(@RequestParam List<Integer> ids){
        return productService.getProductsFromOrigineUniqueFunction(ids);
    }

    //Permet d'obtenir les produits dont les matières premières sont exactement ceux spécifiées dans les paramètres de HTTP à travers les id.
    @GetMapping(value = "/products/matiere", params = "ids")
    public List<Produit> getProductsFromMatiereUnique(@RequestParam List<Integer> ids){

        return productService.getProductsFromMatiereUniqueFunction(ids);
    }





}
