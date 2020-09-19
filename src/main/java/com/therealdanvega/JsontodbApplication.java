package com.therealdanvega;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.therealdanvega.domain.Produit;
import com.therealdanvega.repository.ProduitRepository;

@SpringBootApplication
public class JsontodbApplication {

	public static void main(String[] args) {
		SpringApplication.run(JsontodbApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(ProduitRepository produitRepository){
	    return args -> {
			// read JSON and load json
			ObjectMapper mapper = new ObjectMapper();
			TypeReference<List<Produit>> typeReference = new TypeReference<List<Produit>>(){};
			InputStream inputStream = TypeReference.class.getResourceAsStream("/json/data_with_ids_v3_7.json");
			try {
				List<Produit> produits = mapper.readValue(inputStream,typeReference);
				produitRepository.saveAll(produits);
				System.out.println("Users Saved!");
			} catch (IOException e){
				System.out.println("Unable to save users: " + e.getMessage());
			}
	    };
	    
	}
}
