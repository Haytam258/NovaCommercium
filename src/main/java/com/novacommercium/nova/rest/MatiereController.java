package com.novacommercium.nova.rest;


import com.novacommercium.nova.model.MatierePremiere;
import com.novacommercium.nova.model.Origine;
import com.novacommercium.nova.services.MatiereService;
import com.novacommercium.nova.services.MatiereServiceInterface;
import com.novacommercium.nova.services.OrigineServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MatiereController {

    private final MatiereServiceInterface matiereService;

    private final OrigineServiceInterface origineService;

    @Autowired
    public MatiereController(MatiereServiceInterface matiereService, OrigineServiceInterface origineService){
        this.matiereService = matiereService;
        this.origineService = origineService;
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

    @PostMapping("/addOrigineMatiere/{id}")
    public MatierePremiere addOrigineToM(@PathVariable Long id, @RequestBody Origine origine){
        return matiereService.addOrigineToMatiere(Math.toIntExact(id), origine);
    }

    @PutMapping("/addOrigineMatiere")
    public MatierePremiere addExisitingOrigineMatiere(@RequestParam int idm, @RequestParam int ido){
        return matiereService.addExisitingOrigineToMatiere(idm, ido);
    }

    @GetMapping("/matiereOrigineID/{id}")
    public MatierePremiere getMatiereFromOrigineID(@PathVariable Long id){
        Origine origine = origineService.getOrigineById(Math.toIntExact(id));
        List<Origine> origineList = new ArrayList<>();
        origineList.add(origine);
        return matiereService.getMatiereByOrigineList(origineList);
    }
}
