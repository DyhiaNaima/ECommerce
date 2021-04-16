package org.sid.ecommerce.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import javax.persistence.Entity;
import org.hibernate.validator.constraints.NotEmpty;
@Entity
@Table(name="categorie")
public class Categorie implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idcategorie;
	@NotEmpty
	@Size(min=4, max=15)
	private String nomcategorie;
	@Size(min=8)
	private String description;
	@Lob
	private byte[] photo;
	private String nomPhoto;
	@OneToMany(mappedBy="categorie")
	private Collection<Produit> produits;
	
	
	public Long getIdcategorie() {
		return idcategorie;
	}
	public void setIdcategorie(Long idcategorie) {
		this.idcategorie = idcategorie;
	}
	public String getNomcategorie() {
		return nomcategorie;
	}
	public void setNomcategorie(String nomcategorie) {
		this.nomcategorie = nomcategorie;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public byte[] getPhoto() {
		return photo;
	}
	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}
	public String getNomPhoto() {
		return nomPhoto;
	}
	public void setNomPhoto(String nomPhoto) {
		this.nomPhoto = nomPhoto;
	}
	public Collection<Produit> getProduits() {
		return produits;
	}
	public void setProduits(Collection<Produit> produits) {
		this.produits = produits;
	}
	public Categorie() {
		super();
		// TODO Auto-generated constructor stub
	}
	 
	public Categorie(String nomcategorie, String description, byte[] photo, String nomPhoto) {
		super();
		this.nomcategorie = nomcategorie;
		this.description = description;
		this.photo = photo;
		this.nomPhoto = nomPhoto;
	}

}
