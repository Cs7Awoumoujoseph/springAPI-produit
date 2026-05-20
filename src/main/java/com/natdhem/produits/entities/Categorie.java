package com.natdhem.produits.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Categorie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCat;

    private String nomCat ;
    private String description ;

    @OneToMany(mappedBy = "categorie")
    @JsonIgnore
    private List<Produit> produits ;
}
