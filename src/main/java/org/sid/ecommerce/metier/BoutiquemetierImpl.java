package org.sid.ecommerce.metier;

import java.util.List;


import org.sid.ecommerce.dao.IBoutiqueDAO;
import org.sid.ecommerce.entities.Categorie;
import org.sid.ecommerce.entities.Client;
import org.sid.ecommerce.entities.Commande;
import org.sid.ecommerce.entities.Panier;
import org.sid.ecommerce.entities.Produit;
import org.sid.ecommerce.entities.Role;
import org.sid.ecommerce.entities.User;
import org.springframework.transaction.annotation.Transactional;

@Transactional

public class BoutiquemetierImpl implements IAdminCategoriesMetier {

	private IBoutiqueDAO dao;
	
	public IBoutiqueDAO getDao() {
		return dao;
	}

	public void setDao(IBoutiqueDAO dao) {
		this.dao = dao;
	}
	@Override
	public Long ajouterProduit(Produit p, Long IdCat) { 
		return dao.ajouterProduit(p,IdCat);
	}

	@Override
	public void supprimerProduit(Long idPro) { 
		dao.supprimerProduit(idPro);
	}

	@Override
	public void modifierProduit(Produit p) { 
		dao.modifierProduit(p);		
	}

	@Override
	public List<Categorie> listCategories() { 
		return dao.listCategories();
	}

	@Override
	public Categorie getCategorie(Long idC) { 
		return dao.getCategorie(idC);
	}

	@Override
	public List<Produit> listProduits() { 
		return dao.listProduits();
	}

	@Override
	public List<Produit> listProduitsParMc(String mc) { 
		return dao.listProduitsParMc(mc);
	}

	@Override
	public List<Produit> listProduitsSelectionne() { 
		return dao.listProduitsSelectionne();
	}

	@Override
	public List<Produit> listProduitsParCategorie(Long idCat) { 
		return dao.listProduitsParCategorie(idCat);
	}

	@Override
	public Produit getProduit(Long idPro) { 
		return dao.getProduit(idPro);
	}

	@Override
	public Commande enrigistrerCommande(Panier p, Client c) { 
		return dao.enrigistrerCommande(p, c);
	}

	@Override
	public Long ajouterCategorie(Categorie c) { 
		return dao.ajouterCategorie(c);
	}

	@Override
	public void supprimerCategorie(Long idCat) { 
		dao.supprimerCategorie(idCat);		
	}

	@Override
	public void modifierCategorie(Categorie c) {
		dao.modifierCategorie(c);
		
	}

	@Override
	public void ajouterUser(User u) {
		dao.ajouterUser(u);		
	}

	@Override
	public void attribueRole(Role r, Long userId) {
		dao.attribueRole(r, userId);
		
	}

}
