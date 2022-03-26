package com.novacommercium.nova.repositories;

import com.novacommercium.nova.model.Cooperative;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CooperativeRepoInterface extends JpaRepository<Cooperative, Integer> {
}
