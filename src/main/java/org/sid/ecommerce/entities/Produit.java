package org.sid.ecommerce.entities;

import java.io.Serializable;

 
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.Entity;
import org.hibernate.validator.constraints.NotEmpty;
 
@Entity  
@Table(name="produits")
public class Produit implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idProduit;
	@NotEmpty
	@Size(min=4, max=15)
	private String designation;	 
	private String description;
	private double prix;
	private boolean selected;
	private String nomPhoto;
	private int quantite;
	@ManyToOne
	@JoinColumn(name="idCategorie")
	private Categorie categorie;
	public Produit(String designation, String description, double prix, boolean selected, String nomPhoto,
			int quantite) {  // je suis à 1:18:40 seconde https://www.youtube.com/watch?v=7x6GhIqq2pM
		super();
		this.designation = designation;
		this.description = description;
		this.prix = prix;
		this.selected = selected;
		this.nomPhoto = nomPhoto;
		this.quantite = quantite;
	}
	public Produit() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getIdProduit() {
		return idProduit;
	}
	public void setIdProduit(Long idProduit) {
		this.idProduit = idProduit;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public boolean isSelected() {
		return selected;
	}
	public void setSelected(boolean selected) {
		this.selected = selected;
	}
	public String getNomPhoto() {
		return nomPhoto;
	}
	public void setNomPhoto(String nomPhoto) {
		this.nomPhoto = nomPhoto;
	}
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	public Categorie getCategorie() {
		return categorie;
	}
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
	

}
