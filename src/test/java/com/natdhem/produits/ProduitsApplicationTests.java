package com.natdhem.produits;

import com.natdhem.produits.Repository.ProduitRepository;
import com.natdhem.produits.entities.Categorie;
import com.natdhem.produits.entities.Produit;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;


@SpringBootTest
class ProduitsApplicationTests {
    @Autowired
    private ProduitRepository produitRepository;
    @Test
    public void testCreateProduit() {
        Produit prod = new Produit("PC Dell",2200.500,new Date());
        produitRepository.save(prod);
    }

    @Test
    public void testFindProduit()
    {
        Produit p = produitRepository.findById(1L).get();
        System.out.println(p);
    }

    @Test
    public void testFindProduitByNom(){
        List<Produit> p = produitRepository.findByNomProduit("PC Dell");
        System.out.println(p);
    }

    @Test
    public void testFindByNomProduitContains(){
        List<Produit> p = produitRepository.findByNomProduitContains("p");
        System.out.println(p);
    }

    @Test
    public void testfindByNomPrix()
    {
        List<Produit> prods = produitRepository.findByNomPrix("PC Dell", 1000.0);
        for (Produit p : prods)
        {
            System.out.println(p);
        }
    }

    @Test
    public void testfindByCategorie()
    {
        Categorie cat = new Categorie();
        cat.setIdCat(1L);
        List<Produit> prods = produitRepository.findByCategorie(cat);
        for (Produit p : prods)
        {
            System.out.println(p);
        }
    }

    @Test
    public void findByCategorieIdCat()
    {
        List<Produit> prods = produitRepository.findByCategorieIdCat(1L);
        for (Produit p : prods)
        {
            System.out.println(p);
        }
    }

    @Test
    public void testfindByOrderByNomProduitAsc()
    {
        List<Produit> prods =
                produitRepository.findByOrderByNomProduitAsc();
        for (Produit p : prods)
        {
            System.out.println(p);
        }
    }

    @Test
    public void testTrierProduitsNomsPrix()
    {
        List<Produit> prods = produitRepository.trierProduitsNomsPrix();
        for (Produit p : prods)
        {
            System.out.println(p);
        }
    }



}
