package model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@DiscriminatorValue("admin")
public class Admin extends Compte {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String login;
	private String password;
	private String nom;
	private String prenom;
	
	public Admin() {
	}
	
	public Admin(Integer id, String login, String password, String nom, String prenom) {
		this.id = id;
		this.login = login;
		this.password = password;
		this.nom = nom;
		this.prenom = prenom;
	}
	
	@Override
	public String toString() {
		return "Admin [id=" + id + ", login=" + login + ", password=" + password + ", nom=" + nom + ", prenom=" + prenom
				+ "]";
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	

}
