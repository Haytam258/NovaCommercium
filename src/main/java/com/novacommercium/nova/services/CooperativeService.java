package com.novacommercium.nova.services;

import com.novacommercium.nova.model.Cooperative;
import com.novacommercium.nova.repositories.CooperativeRepoInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CooperativeService implements CooperativeServiceInterface {

    private final CooperativeRepoInterface cooperativeRepo;

    @Autowired
    public CooperativeService(CooperativeRepoInterface cooperativeRepo){
        this.cooperativeRepo = cooperativeRepo;
    }

    public Cooperative getCooperativeById(int id){
        return cooperativeRepo.findById(id).get();
    }
}
