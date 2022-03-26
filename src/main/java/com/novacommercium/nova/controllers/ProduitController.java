package com.novacommercium.nova.controllers;


import com.novacommercium.nova.model.Produit;
import com.novacommercium.nova.services.ProduitService;
import com.novacommercium.nova.services.ProduitServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/")
public class ProduitController {

    private final ProduitServiceInterface productService;

    @Autowired
    public ProduitController(ProduitService productService){
        this.productService = productService;
    }


    @GetMapping("/createProduct")
    public String showPageCreateProduct(Model model){
        model.addAttribute("newProduct", new Produit());
        return "createProduct";
    }

    @PostMapping("/createProduct")
    public String createProduct(@ModelAttribute Produit product, Model model){
        //It works, adds the entry to database so we're good on this part so far :D
        productService.createProduct(product);
        model.addAttribute("newProduct", product);
        return "createProduct";

    }

    @RequestMapping("/productList")
    public String productList(Model model){
        List<Produit> prodList = productService.getAllProducts();
        model.addAttribute("prodList", prodList);
        return "productList";
    }

    @RequestMapping("/deleteProduct")
    public String deleteProduct(@RequestParam Long id){
        //This one works as well, Note : the value passed in the form is not an int but a Long int type, so be careful!
        productService.deleteProductById(Math.toIntExact(id));
        return "redirect:/productList";
    }
}
