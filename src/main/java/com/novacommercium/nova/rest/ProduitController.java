package com.novacommercium.nova.rest;


import com.novacommercium.nova.model.MatierePremiere;
import com.novacommercium.nova.model.Produit;
import com.novacommercium.nova.services.MatiereServiceInterface;
import com.novacommercium.nova.services.ProduitService;
import com.novacommercium.nova.services.ProduitServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProduitController {

    private final ProduitServiceInterface productService;

    private final MatiereServiceInterface matiereService;

    @Autowired
    public ProduitController(ProduitServiceInterface productService, MatiereServiceInterface matiereService ){
        this.productService = productService;
        this.matiereService = matiereService;
    }


    @GetMapping("/showProduct")
    public String showPageCreateProduct(Model model){
        model.addAttribute("newProduct", new Produit());
        return "createProduct";
    }

    @PostMapping("/createProduct")
    public void createProduct(@RequestBody Produit product){
        //It works, adds the entry to database so we're good on this part so far :D
        productService.createProduct(product);
    }

    @GetMapping("/productList")
    public List<Produit> productList(){
        return productService.getAllProducts();
    }

    @DeleteMapping("/deleteProduct")
    public void deleteProduct(@RequestParam Long id){
        //This one works as well, Note : the value passed in the form is not an int but a Long int type, so be careful!
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

    @GetMapping("/productMatiere")
    public Produit getProduitFromMatiere(@RequestBody MatierePremiere matierePremiere){
        List<MatierePremiere> matList = new ArrayList<>();
        matList.add(matierePremiere);
        return productService.getProductByMatiereList(matList);
    }

    @GetMapping("/productMatiereID/{id}")
    public Produit getProduitFromMatiereID(@PathVariable Long id){
        MatierePremiere mat = matiereService.getMatiereById(Math.toIntExact(id));
        List<MatierePremiere> matList = new ArrayList<>();
        matList.add(mat);
        return productService.getProductByMatiereList(matList);
    }


}
