package org.sid.ecommerce.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.sid.ecommerce.entities.Categorie;
import org.sid.ecommerce.entities.Client;
import org.sid.ecommerce.entities.Commande;
import org.sid.ecommerce.entities.LigneCommande;
import org.sid.ecommerce.entities.Panier;
import org.sid.ecommerce.entities.Produit;
import org.sid.ecommerce.entities.Role;
import org.sid.ecommerce.entities.User;

public class BoutiqueDaoImpl implements IBoutiqueDAO{
	@PersistenceContext
	private EntityManager em;

	@Override
	public Long ajouterCategorie(Categorie c) {
		// TODO Auto-generated method stub
		em.persist(c);
		return c.getIdcategorie();
	}

	@Override
	public List<Categorie> listCategories() {
		// TODO Auto-generated method stub
		Query req = em.createQuery("select c from Categorie c");
		return req.getResultList();
	}

	@Override
	public Categorie getCategorie(Long idCat) {
		// TODO Auto-generated method stub
		return em.find(Categorie.class, idCat);
	}

	@Override
	public void supprimerCategorie(Long idCat) {
		// TODO Auto-generated method stub
		Categorie c = em.find(Categorie.class, idCat);
		em.remove(c);
		
	}

	@Override
	public void modifierCategorie(Categorie c) {
		// TODO Auto-generated method stub
		em.merge(c);
	}

	@Override
	public Long ajouterProduit(Produit p, Long IdCat) {
		// TODO Auto-generated method stub
		Categorie c = getCategorie(IdCat);
		p.setCategorie(c);
		em.persist(p);
		return p.getIdProduit();
	}

	@Override
	public List<Produit> listProduits() {
		// TODO Auto-generated method stub
		Query req = em.createQuery("select p from Produit p");
		return req.getResultList();
	}

	@Override
	public List<Produit> listProduitsParMc(String mc) {
		// TODO Auto-generated method stub
		Query req = em.createQuery("select p from Produit p where p.designation like :x or description like :x");
		req.setParameter("x","%"+ mc + "%");
		return req.getResultList();
	}

	@Override
	public List<Produit> listProduitsSelectionne() {
		// TODO Auto-generated method stub
		Query req = em.createQuery("select p from Produit p where  p.selectionne = true"); 
		return req.getResultList();
	}

	@Override
	public List<Produit> listProduitsParCategorie(Long idCat) {
		// TODO Auto-generated method stub
		Query req = em.createQuery("select p from Produit p where  p.categorie.idcategorie = :x"); 
		return req.getResultList();
	}

	@Override
	public Produit getProduit(Long idPro) {
		// TODO Auto-generated method stub
		return em.find(Produit.class, idPro);
	}

	@Override
	public void supprimerProduit(Long idPro) { 
		 em.remove(getProduit(idPro));
	}

	@Override
	public void modifierProduit(Produit p) { 
		em.merge(p);
	}

	@Override
	public void ajouterUser(User u) { 
		em.persist(u);
	}

	@Override
	public void attribueRole(Role r , Long userId) {
		User u = em.find(User.class, userId);
		u.getRoles().add(r);
		em.persist(r); 
	}

	@Override
	public Commande enrigistrerCommande(Panier p, Client c) { 
		em.persist(c);
		Commande cmd = new Commande();
		cmd.setDateCommande(new Date());
		cmd.setItems(p.getItems());
		for(LigneCommande lc : p.getItems()) {
			em.persist(lc);
		}
		em.persist(cmd);
		return null;
		
	}

}
