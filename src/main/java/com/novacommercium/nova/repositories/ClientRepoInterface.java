package com.novacommercium.nova.repositories;

import com.novacommercium.nova.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepoInterface extends JpaRepository<Client, Integer> {

    public Client findClientByUsername(String username);
}
