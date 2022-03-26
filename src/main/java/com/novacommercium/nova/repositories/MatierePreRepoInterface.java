package com.novacommercium.nova.repositories;

import com.novacommercium.nova.model.MatierePremiere;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatierePreRepoInterface extends JpaRepository<MatierePremiere, Integer> {

    public MatierePremiere getMatierePremiereByName(String name);

}
