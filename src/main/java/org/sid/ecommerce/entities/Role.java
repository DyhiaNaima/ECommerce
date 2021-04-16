package org.sid.ecommerce.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Role implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idRole;
	private String roleName;
	public Long getIdRole() {
		return idRole;
	}
	public void setIdRole(Long idRole) {
		this.idRole = idRole;
	}
	public String getRoleNama() {
		return roleName;
	}
	public void setRoleNama(String roleNama) {
		this.roleName = roleNama;
	}
	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Role(String roleNama) {
		super();
		this.roleName = roleNama;
	}
 

}
