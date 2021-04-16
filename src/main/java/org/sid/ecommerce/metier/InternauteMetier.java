package org.sid.ecommerce.metier;

import java.util.List;

import org.sid.ecommerce.entities.Categorie;
import org.sid.ecommerce.entities.Client;
import org.sid.ecommerce.entities.Commande;
import org.sid.ecommerce.entities.Panier;
import org.sid.ecommerce.entities.Produit;

public interface InternauteMetier {
	
	public List<Categorie> listCategories();
	public Categorie getCategorie(Long idC);
	public List<Produit> listProduits();
	public List<Produit> listProduitsParMc(String mc);
	public List<Produit> listProduitsSelectionne();
	public List<Produit> listProduitsParCategorie(Long idCat);
	public Produit getProduit(Long idPro);
	public Commande enrigistrerCommande(Panier p , Client c);

}
