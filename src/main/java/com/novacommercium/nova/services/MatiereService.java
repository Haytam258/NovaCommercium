package com.novacommercium.nova.services;

import com.novacommercium.nova.model.MatierePremiere;
import com.novacommercium.nova.model.Origine;
import com.novacommercium.nova.repositories.MatierePreRepoInterface;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MatiereService implements MatiereServiceInterface{

    private final MatierePreRepoInterface matiereRepo;

    @Autowired
    public MatiereService(MatierePreRepoInterface matiereRepo){
        this.matiereRepo = matiereRepo;
    }

    public void addMatiere(MatierePremiere matiere){
        matiereRepo.saveAndFlush(matiere);
    }

    public void deleteMatiere(MatierePremiere matiere){
        matiereRepo.delete(matiere);
    }

    public void deleteMatiereById(int id){
        matiereRepo.deleteById(id);
    }

    public MatierePremiere getMatiereById(int id){
        return matiereRepo.findById(id).get();
    }

    public MatierePremiere getMatiereByName(String name){
        return matiereRepo.getMatierePremiereByName(name);
    }

    public List<MatierePremiere> getMatieres(){
        return matiereRepo.findAll();
    }

    public void modifyMatiere(MatierePremiere matiere, String name){
        matiere.setName(name);
        matiereRepo.saveAndFlush(matiere);
    }

    /*public List<MatierePremiere> getMatieresByOrigineList(List<Origine> origineList){
        return matiereRepo.getMatierePremieresByOrigineList(origineList);
    }

    public MatierePremiere getMatiereByOrigineList(List<Origine> origineList){
        return matiereRepo.getMatierePremiereByOrigineList(origineList);
    }*/

}
