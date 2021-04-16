package org.sid.ecommerce;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.sid.ecommerce.entities.Categorie;
import org.sid.ecommerce.entities.Produit;
import org.sid.ecommerce.metier.IAdminCategoriesMetier;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestJPA {
	ClassPathXmlApplicationContext context ;
	@Before 
	public void setUp() throws Exception{
		context = new ClassPathXmlApplicationContext(new String[] {"applicationContext.xml"});
	}
	
	/*@Test
	public void test1() {
		try { 
			context = new ClassPathXmlApplicationContext(new String[] {"applicationContext.xml"});
			 
			assertTrue(true);

		}catch (Exception e){
			assertTrue(e.getMessage(), false);
		}
	}*/
	@Test
	public void test1() {
		try { 
			IAdminCategoriesMetier metier = (IAdminCategoriesMetier) context.getBean("metier");
			List<Categorie> cts1 = metier.listCategories();
			metier.ajouterCategorie(new Categorie("Ordinateur", "Ordinateur1", null, "image1.jpg"));
			metier.ajouterCategorie(new Categorie("Imprimante", "Imprimante1", null, "image2.jpg"));
			List<Categorie> cts2 = metier.listCategories();
			assertTrue(cts1.size()+2==cts2.size());

		}catch (Exception e){
			assertTrue(e.getMessage(), false);
		}
	}
	
	@Test
	public void test2() {
		try {
			  
			IAdminCategoriesMetier metier = (IAdminCategoriesMetier) context.getBean("metier");
			List<Produit> prods = metier.listProduits();
			metier.ajouterProduit(new Produit("HP45", "HP7890", 2000, true, "image1.jpg", 50),1L); 
			metier.ajouterProduit(new Produit("Azerty", "AZ2340", 3000, true, "image2.jpg", 50),1L); 

			List<Produit> prods2 = metier.listProduits();
			assertTrue(prods.size()+2==prods2.size());

		}catch (Exception e){
			assertTrue(e.getMessage(), false);
		}
	}

}
