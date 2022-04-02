package com.novacommercium.nova.services;

import com.novacommercium.nova.model.MatierePremiere;
import com.novacommercium.nova.model.Origine;
import org.springframework.stereotype.Service;

import java.util.List;

public interface OrigineServiceInterface {

    public void addOrigine(Origine origine);
    public void deleteOrigine(Origine origine);
    public void deleteOrigineById(int id);
    public Origine getOrigineById(int id);
    public Origine getOrigineByEndroit(String endroit);
    public List<Origine> getOrigines();
    public void modifyOrigine(Origine origine,String endroit);
    public Origine updateOrigine(int id, Origine origine);
    /*public List<Origine> getOriginesByMatiereList(List<MatierePremiere> matierePremiereList);
    public Origine getOrigineByMatiereList(List<MatierePremiere> matierePremiereList);*/

}
