package com.novacommercium.nova.model;

import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Builder
@Data
public class ProduitSearchCriteria {
    private Set<String> origineList;
}
