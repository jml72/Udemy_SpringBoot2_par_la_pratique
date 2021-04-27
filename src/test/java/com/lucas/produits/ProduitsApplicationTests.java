package com.lucas.produits;

import com.lucas.produits.entities.Categorie;
import com.lucas.produits.entities.Produit;
import com.lucas.produits.repos.ProduitRepository;
import com.lucas.produits.service.ProduitService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import java.util.Date;
import java.util.List;

@SpringBootTest
class ProduitsApplicationTests {

	@Autowired
	private ProduitRepository produitRepository;
	private ProduitService produitService;

	@Test
	public void testCreateProduit() {
		Produit prod = new Produit("PC Dell", 2200.500, new Date());
		produitRepository.save(prod);
	}

	@Test
	public void testFindProduit() {
		Produit p = produitRepository.findById(1L).get();
		System.out.println(p);
	}

	@Test
	public void testUpdateProduit() {
		Produit p = produitRepository.findById(1L).get();
		p.setPrixProduit(1000.0);
		produitRepository.save(p);
	}

	@Test
	public void testFindByNomProduit() {
		List<Produit> prods = produitRepository.findByNomProduit("PS 4");
		for (Produit p:prods) {
			System.out.println(p);}
	}

	@Test
	public void testFindByNomProduitContains () {
		List<Produit> prods=produitRepository.findByNomProduitContains("iphone X");
		for (Produit p : prods)
		{
			System.out.println(p);
		}
		}

	@Test
	public void testfindByNomPrix()
	{
		List<Produit> prods = produitRepository.findByNomPrix("PC Dell", 2000.0);
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
	public void findByCategorieIdCat() {
		List<Produit> prods = produitRepository.findByCategorieIdCat(2L);
		for (Produit p : prods)
		{
			System.out.println(p);
		}

	}

	@Test
	public void findByOrderByNomProduitASc() {
		List<Produit> prods = produitRepository.findByOrderByNomProduitAsc();
		for (Produit p : prods)
		{
			System.out.println(p);
		}
	}

	@Test
	public void trierProduitNomPrix() {
		List<Produit> prods = produitRepository.trierProduitsNomPrix();
		for (Produit p : prods)
		{
			System.out.println(p);
		}
	}



	}



	/*@Test
	public void testFindByNomProduitContains()
	{
		Page<Produit> prods = produitService.getAllProduitsParPage(0,2);
		System.out.println(prods.getSize());
		System.out.println(prods.getTotalElements());
		System.out.println(prods.getTotalPages());
		prods.getContent().forEach(p -> {System.out.println(p.toString());
		});
		/*ou bien
		for (Produit p : prods.getContent())
		{
		System.out.println(p);
		} */




