package org.sid.ecommerce.metier;

import org.sid.ecommerce.entities.Categorie;
import org.sid.ecommerce.entities.Role;
import org.sid.ecommerce.entities.User;

public interface IAdminCategoriesMetier extends IAdminProduitsMetier{
	public Long ajouterCategorie(Categorie c );
	public void supprimerCategorie(Long idCat);
	public void modifierCategorie(Categorie c);
	
	public void ajouterUser(User u );
	public void attribueRole(Role r, Long userId);
}
