package com.natdhem.produits.Repository;

import com.natdhem.produits.entities.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;


@RepositoryRestResource(path = "cat")
@CrossOrigin("http://localhost:4200/") //pour autoriser angular
public interface CategorieRepository extends JpaRepository<Categorie,Long> {
    List<Categorie> findAll();
}
