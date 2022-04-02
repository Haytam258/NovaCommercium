package com.novacommercium.nova.services;

import com.novacommercium.nova.model.MatierePremiere;
import com.novacommercium.nova.model.Origine;
import com.novacommercium.nova.repositories.OrigineRepoInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrigineService implements OrigineServiceInterface{

    private final OrigineRepoInterface origineRepo;

    @Autowired
    public OrigineService(OrigineRepoInterface origineRepo){
        this.origineRepo = origineRepo;
    }

    public void addOrigine(Origine origine){
        origineRepo.saveAndFlush(origine);
    }

    public void deleteOrigine(Origine origine){
        origineRepo.delete(origine);
    }

    public void deleteOrigineById(int id){
        origineRepo.deleteById(id);
    }

    public Origine getOrigineById(int id){
        return origineRepo.findById(id).get();
    }

    public Origine getOrigineByEndroit(String endroit){
        return origineRepo.findOrigineByEndroit(endroit);
    }

    public List<Origine> getOrigines(){
        return origineRepo.findAll();
    }

    public void modifyOrigine(Origine origine,String endroit){
        origine.setEndroit(endroit);
        origineRepo.saveAndFlush(origine);
    }

    public Origine updateOrigine(int id, Origine origine){
        Origine orig = origineRepo.findById(Math.toIntExact(id)).get();
        orig.setEndroit(origine.getEndroit());
        origineRepo.saveAndFlush(orig);
        return orig;
    }

   public List<Origine> getOriginesByMatiereList(List<MatierePremiere> matierePremiereList){
        return origineRepo.findOriginesByMatierePremiereListIn(matierePremiereList);
    }

    public Origine getOrigineByMatiereList(List<MatierePremiere> matierePremiereList){
        return origineRepo.findOrigineByMatierePremiereListIn(matierePremiereList);
    }
}
