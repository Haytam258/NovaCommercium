package com.novacommercium.nova.services;

import com.novacommercium.nova.model.MatierePremiere;
import com.novacommercium.nova.model.Origine;
import com.novacommercium.nova.repositories.MatierePreRepoInterface;
import com.novacommercium.nova.repositories.OrigineRepoInterface;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatiereService implements MatiereServiceInterface{

    //This doesn't follow Single Responsibility Principle, meaning my design, be it code or database, is bad but not
    //enough time to learn and redesign / refactor classes :(

    private final MatierePreRepoInterface matiereRepo;

    private final OrigineRepoInterface origineRepo;

    @Autowired
    public MatiereService(MatierePreRepoInterface matiereRepo, OrigineRepoInterface origineRepo){
        this.matiereRepo = matiereRepo;
        this.origineRepo = origineRepo;
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
        return matiereRepo.findByName(name);
    }

    public List<MatierePremiere> getMatieres(){
        return matiereRepo.findAll();
    }

    public void modifyMatiere(MatierePremiere matiere, String name){
        matiere.setName(name);
        matiereRepo.saveAndFlush(matiere);
    }

    public MatierePremiere updateMatiere(int id, MatierePremiere matierePremiere){
        MatierePremiere mat = matiereRepo.findById(id).get();
        mat.setName(matierePremiere.getName());
        matiereRepo.saveAndFlush(mat);
        return mat;
    }

    public MatierePremiere addOrigineToMatiere(int id, Origine origine){
        MatierePremiere mat = matiereRepo.findById(id).get();
        mat.getOrigineList().add(origine);
        matiereRepo.saveAndFlush(mat);
        return mat;
    }

    public MatierePremiere addExisitingOrigineToMatiere(int idm, int ido){
        MatierePremiere mat = matiereRepo.findById(idm).get();
        Origine origine = origineRepo.findById(ido).get();
        mat.getOrigineList().add(origine);
        matiereRepo.saveAndFlush(mat);
        return mat;
    }

    /*public List<MatierePremiere> getMatieresByOrigineList(List<Origine> origineList){
        return matiereRepo.getMatierePremieresByOrigineList(origineList);
    }

    public MatierePremiere getMatiereByOrigineList(List<Origine> origineList){
        return matiereRepo.getMatierePremiereByOrigineList(origineList);
    }*/

}
