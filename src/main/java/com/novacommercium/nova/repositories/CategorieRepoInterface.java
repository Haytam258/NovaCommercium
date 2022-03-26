package com.novacommercium.nova.repositories;

import com.novacommercium.nova.model.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategorieRepoInterface extends JpaRepository<Categorie, Integer> {
}
