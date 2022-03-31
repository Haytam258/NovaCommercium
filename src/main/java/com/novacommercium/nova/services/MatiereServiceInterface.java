package com.novacommercium.nova.services;

import com.novacommercium.nova.model.MatierePremiere;
import com.novacommercium.nova.model.Origine;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MatiereServiceInterface {

    public void addMatiere(MatierePremiere matiere);
    public void deleteMatiere(MatierePremiere matiere);
    public void deleteMatiereById(int id);
    public MatierePremiere getMatiereById(int id);
    public MatierePremiere getMatiereByName(String name);
    public List<MatierePremiere> getMatieres();
    public void modifyMatiere(MatierePremiere matiere, String name);
   /* public MatierePremiere getMatiereByOrigineList(List<Origine> origineList);
    public List<MatierePremiere> getMatieresByOrigineList(List<Origine> origineList);*/

}
