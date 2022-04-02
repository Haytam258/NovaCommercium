package com.novacommercium.nova.rest;


import com.novacommercium.nova.model.Origine;
import com.novacommercium.nova.services.OrigineService;
import com.novacommercium.nova.services.OrigineServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrigineController {

    private final OrigineServiceInterface origineService;

    @Autowired
    public OrigineController(OrigineServiceInterface origineService){
        this.origineService = origineService;
    }
    @GetMapping("/origines")
    public List<Origine> getOrigines(){
        return origineService.getOrigines();
    }

    @GetMapping("/origines/{id}")
    public Origine getOrigine(@PathVariable long id){
       return origineService.getOrigineById(Math.toIntExact(id));
    }

    //there's usually 3 ways to pass information, with HTTP Request's body or with the Path variable in the URI/Header as
    // Key:value
    @PostMapping("/createOrigine")
    public void createOrigine(@RequestBody Origine origine){
        origineService.addOrigine(origine);
    }

    @DeleteMapping("/origine/{id}")
    public void deleteOrigine(@PathVariable Long id){
        origineService.deleteOrigineById(Math.toIntExact(id));
    }

    @PutMapping("/origine/{id}")
    public Origine updateOrigine(@PathVariable Long id, @RequestBody Origine origine){
        return origineService.updateOrigine(Math.toIntExact(id), origine);
    }

}
