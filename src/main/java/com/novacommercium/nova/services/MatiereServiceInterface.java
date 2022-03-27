package com.novacommercium.nova.services;

import com.novacommercium.nova.model.MatierePremiere;
import com.novacommercium.nova.model.Origine;

import java.util.List;

public interface MatiereServiceInterface {

    public MatierePremiere getMatiereByOrigineList(List<Origine> origineList);
    public void addMatiere(MatierePremiere matiere);
    public void deleteMatiere(MatierePremiere matiere);
    public void deleteMatiereById(int id);
    public MatierePremiere getMatiereById(int id);
    public MatierePremiere getMatiereByName(String name);
    public List<MatierePremiere> getMatieres();
    public void modifyMatiere(MatierePremiere matiere, String name);
    public List<MatierePremiere> getMatieresByOrigineList(List<Origine> origineList);

}
