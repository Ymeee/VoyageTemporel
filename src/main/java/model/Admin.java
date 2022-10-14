package model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@DiscriminatorValue("admin")
public class Admin extends Compte {
	
	
	
	public Admin() {
	}
	
	public Admin(Integer id, String login, String password, String nom, String prenom) {
		super(id, login, password, nom, prenom);
	}
	
	
}
