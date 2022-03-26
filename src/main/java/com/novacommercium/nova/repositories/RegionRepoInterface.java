package com.novacommercium.nova.repositories;

import com.novacommercium.nova.model.Region;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegionRepoInterface extends JpaRepository<Region, Integer> {
}
