package com.novacommercium.nova.services;

import com.novacommercium.nova.model.MatierePremiere;
import com.novacommercium.nova.model.Origine;
import org.springframework.stereotype.Service;

import java.util.List;

public interface MatiereServiceInterface {

    public void addMatiere(MatierePremiere matiere);
    public void deleteMatiere(MatierePremiere matiere);
    public void deleteMatiereById(int id);
    public MatierePremiere getMatiereById(int id);
    public MatierePremiere getMatiereByName(String name);
    public List<MatierePremiere> getMatieres();
    public void modifyMatiere(MatierePremiere matiere, String name);
    public MatierePremiere updateMatiere(int id, MatierePremiere matierePremiere);
    public MatierePremiere addOrigineToMatiere(int id, Origine origine);
    public MatierePremiere addExisitingOrigineToMatiere(int idm, int ido);
   /* public MatierePremiere getMatiereByOrigineList(List<Origine> origineList);
    public List<MatierePremiere> getMatieresByOrigineList(List<Origine> origineList);*/

}
