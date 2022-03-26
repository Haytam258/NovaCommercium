package com.novacommercium.nova.repositories;

import com.novacommercium.nova.model.Origine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrigineRepoInterface extends JpaRepository<Origine, Integer> {

    public Origine getOrigineByEndroit(String endroit);
}
