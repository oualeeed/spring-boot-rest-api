package com.fsr.eshopspringboot.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fsr.eshopspringboot.entities.Produit;

@Repository
public interface ProduitRepository extends CrudRepository<Produit, Long> {

}
