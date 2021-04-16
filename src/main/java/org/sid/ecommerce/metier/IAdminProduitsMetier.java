package org.sid.ecommerce.metier;

import org.sid.ecommerce.entities.Produit;

public interface IAdminProduitsMetier extends InternauteMetier{
	public Long ajouterProduit(Produit p, Long  IdCat);
	public void supprimerProduit(Long idPro);
	public void modifierProduit(Produit p);
	
}
