package com.therealdanvega.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.therealdanvega.domain.Produit;
import com.therealdanvega.repository.ProduitRepository;

@Controller


public class ProduitController {

	@Autowired
	private	ProduitRepository produitRepository;
	@GetMapping(path="/index")
	public String index(){
		return "index";
	}
	@GetMapping(path="/produits")
	public String list(Model model, Pageable pageable,
			@RequestParam(name="page",defaultValue="0") int page,
			@RequestParam(name="size",defaultValue="200") int size,
	@RequestParam(name="keyword",defaultValue="")String mc
			) {
		Page<Produit> pages = produitRepository.findByNomContains(mc,PageRequest.of(page, size));
		model.addAttribute("number", pages.getNumber());
		model.addAttribute("totalPages", pages.getTotalPages());
		model.addAttribute("totalPages", pages.getTotalPages());
		model.addAttribute("totalElements", pages.getTotalElements());
		model.addAttribute("currentPage",page);
		model.addAttribute("size",size);
		model.addAttribute("produits", pages.getContent());
		return "produits";}
	@GetMapping("/refresh")
	public String refreshCache(Model model, Pageable pageable) {
		//produitRepository.r;
		Page<Produit> pages = produitRepository.findAll(pageable);
		model.addAttribute("number", pages.getNumber());
		model.addAttribute("totalPages", pages.getTotalPages());
		model.addAttribute("totalElements", pages.getTotalElements());
		model.addAttribute("size", pages.getSize());
		model.addAttribute("produits", pages.getContent());
		return "produits";
	}
	/*@GetMapping(path="/produits")
	public String list(Model model,
			@RequestParam(name="page",defaultValue="0") int page,
			@RequestParam(name="size",defaultValue="3") int size,
	@RequestParam(name="keyword",defaultValue="")String mc){
		Page<Produit>pageProduits=produitRepository.findByNomContains(mc,PageRequest.of(page, size));
		model.addAttribute("produits",pageProduits.getContent());
		model.addAttribute("pages",new int [pageProduits.getTotalPages()]);
		model.addAttribute("currentPage",page);
		model.addAttribute("size",size);
		model.addAttribute("keyword",mc);
		return "produits";
	}
	
/*	@GetMapping(path="/produit")
	

	public String list(Model model){
		List<Produit>produits=produitRepository.findAll();
		model.addAttribute("produits",produits);
		
		Produit produit=new Produit();
		ObjectMapper objectMapper=new ObjectMapper();
		try {
			String jsonStr=objectMapper.writeValueAsString(produits);
			System.out.println(jsonStr);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "produit";
	}*/
			
	
	/*@GetMapping(path="/deleteProduit")
	public String delete(Long id,String keyword){
		produitRepository.deleteById(id);
		return "redirect:/patients?keyword="+keyword;
	}
	@GetMapping(path="/deleteProduit2")
	public String delete(Long id,String keyword,Model model){
		produitRepository.deleteById(id);
		return list(model, keyword);
	}
	@GetMapping(path="/formProduit")
	public String formProduit(Model model){
		model.addAttribute("produit",new Produit());
		model.addAttribute("mode","new");
		return "formProduit";
	}
	@GetMapping(path="/editProduit")
	public String editProduit(Model model,Long id){
		Produit p=produitRepository.findById(id).get();
		model.addAttribute("produit",p);
		model.addAttribute("mode", "edit");
		return "formProduit";
	}
	@PostMapping(path="/savePatient")
	public String savePatient(Model model,@Valid Produit produit,BindingResult bindingResult){
		if (bindingResult.hasErrors()) return "formProduit";
			produitRepository.save(produit);
			model.addAttribute("produit",produit);
			return "confirmation";
			
		

		

	}*/
}
