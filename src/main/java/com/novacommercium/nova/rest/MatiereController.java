package com.novacommercium.nova.rest;


import com.novacommercium.nova.model.MatierePremiere;
import com.novacommercium.nova.services.MatiereService;
import com.novacommercium.nova.services.MatiereServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MatiereController {

    private final MatiereServiceInterface matiereService;

    @Autowired
    public MatiereController(MatiereServiceInterface matiereService){
        this.matiereService = matiereService;
    }

    @GetMapping("/matieres")
    public List<MatierePremiere> getMatieres(){
        return matiereService.getMatieres();
    }

    @GetMapping("/matiere/{id}")
    public MatierePremiere getMatiere(@PathVariable Long id){
        return matiereService.getMatiereById(Math.toIntExact(id));
    }

    @DeleteMapping("/matieres/{id}")
    public void deleteMatiere(@PathVariable Long id){
        matiereService.deleteMatiereById(Math.toIntExact(id));
    }

    @PutMapping("/matieres/{id}")
    public MatierePremiere updateMatiere(@PathVariable Long id, @RequestBody MatierePremiere matierePremiere){
        return matiereService.updateMatiere(Math.toIntExact(id), matierePremiere);
    }

    @PostMapping("/createMatiere")
    public void createMatiere(@RequestBody MatierePremiere matierePremiere){
        matiereService.addMatiere(matierePremiere);
    }
}
