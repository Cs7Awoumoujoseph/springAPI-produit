package com.natdhem.produits.RESTController;

import com.natdhem.produits.entities.Produit;
import com.natdhem.produits.service.ProduitService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
@AllArgsConstructor
public class ProduitRESTController {

   // @Autowired
    private final ProduitService produitService ;

    @RequestMapping(path="all",method =RequestMethod.GET)
    public List<Produit> getAllProduits() {
        return produitService.getAllProduits();
    }
    @RequestMapping(value="/getbyid/{id}",method = RequestMethod.GET)
    public Produit getProduitById(@PathVariable("id") Long id) {
        return produitService.getProduit(id);
    }
    @RequestMapping(path="/addprod",method = RequestMethod.POST)
    public Produit createProduit(@RequestBody Produit produit) {
        return produitService.saveProduit(produit);
    }
    @RequestMapping(path="/updateprod",method = RequestMethod.PUT)
    public Produit updateProduit(@RequestBody Produit produit) {
        return produitService.updateProduit(produit);
    }
    @RequestMapping(value="/delprod/{id}",method = RequestMethod.DELETE)
    public void deleteProduit(@PathVariable("id") Long id)
    {
        produitService.deleteProduitById(id);
    }
    @RequestMapping(value="/prodscat/{idCat}",method = RequestMethod.GET)
    public List<Produit> getProduitsByCatId(@PathVariable("idCat") Long idCat) {
        return produitService.findByCategorieIdCat(idCat);
    }

}
