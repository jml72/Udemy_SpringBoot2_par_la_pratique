package com.lucas.produits.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Categorie {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long idCat;
    private String nomCat;
    private String descriptionCat;
    @JsonIgnore
    @OneToMany (mappedBy = "categorie")
    private List<Produit> produits;

    public Categorie() {
    }

    public Categorie(String nomCat, String descriptionCat, List<Produit> produits) {
        this.nomCat = nomCat;
        this.descriptionCat = descriptionCat;
        this.produits = produits;
    }


}
