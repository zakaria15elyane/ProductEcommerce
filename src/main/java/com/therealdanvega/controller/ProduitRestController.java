package com.therealdanvega.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.therealdanvega.domain.Produit;
import com.therealdanvega.repository.ProduitRepository;

@RestController


public class ProduitRestController {

	@Autowired
	private	ProduitRepository produitRepository;


	@GetMapping(path="/produit")
	 public List<Produit>produits(){
	return produitRepository.findAll();
	}
	
}
