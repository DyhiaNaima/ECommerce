package org.sid.ecommerce.dao;

import java.util.List;

 

import org.sid.ecommerce.entities.Categorie;
import org.sid.ecommerce.entities.Client;
import org.sid.ecommerce.entities.Commande;
import org.sid.ecommerce.entities.Panier;
import org.sid.ecommerce.entities.Produit;
import org.sid.ecommerce.entities.Role;
import org.sid.ecommerce.entities.User;

public interface IBoutiqueDAO {

	/* CATEGORIE  */
	public Long ajouterCategorie(Categorie c );
	public List<Categorie> listCategories();
	public Categorie getCategorie(Long idCat);
	public void supprimerCategorie(Long idCat);
	public void modifierCategorie(Categorie c);
	/* PRODUIT  */
	public Long ajouterProduit(Produit p, Long  IdCat);
	public List<Produit> listProduits();
	public List<Produit> listProduitsParMc(String mc);
	public List<Produit> listProduitsSelectionne();
	public List<Produit> listProduitsParCategorie(Long idCat);
	public Produit getProduit(Long idPro);
	public void supprimerProduit(Long idPro);
	public void modifierProduit(Produit p);
	
	/* USER  */
	public void ajouterUser(User u );
	public void attribueRole(Role r, Long userId);
	
	public Commande enrigistrerCommande(Panier p , Client c);
	
}
