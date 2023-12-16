package com.fsr.eshopspringboot.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fsr.eshopspringboot.entities.Produit;
import com.fsr.eshopspringboot.repositories.ProduitRepository;

@RestController
@RequestMapping("/api/produits")
public class ProduitController {

  @Autowired
  ProduitRepository produitRepository;

  @PostMapping
  public String saveProduit(@RequestBody Produit produit) {
    System.out.println("I hate my self");
    this.produitRepository.save(produit);
    return "saved";
  }

  @GetMapping("/{id}")
  public Produit getProduit(@PathVariable("id") final Long id) {
    Optional<Produit> optionalProduit = produitRepository.findById(id);

    if (optionalProduit.isPresent()) {
      return optionalProduit.get();
    }

    return null;
  }

  @GetMapping
  public Iterable<Produit> getProduits() {
    return this.produitRepository.findAll();
  }

  @PutMapping("/{id}")
  public Produit modifierProduit(@PathVariable("id") final Long id, @RequestBody Produit produit) {
    Optional<Produit> optionalProduit = this.produitRepository.findById(id);

    if (!optionalProduit.isPresent()) {
      return null;
    }

    Produit produitAModifie = optionalProduit.get();
    if (produit.getNom() != null) {
      produitAModifie.setNom(produit.getNom());
    }

    if (produit.getDescription() != null) {
      produitAModifie.setDescription(produit.getDescription());
    }

    if (produit.getDispo() != null) {
      produitAModifie.setDispo(produit.getDispo());
    }

    if (produit.getPrix() != null) {
      produitAModifie.setPrix(produit.getPrix());
    }

    return produitAModifie;
  }

  @DeleteMapping("/{id}")
  public void supprimerProduit(@PathVariable("id") final Long id) {
    this.produitRepository.deleteById(id);
  }

}
