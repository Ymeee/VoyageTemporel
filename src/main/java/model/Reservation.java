package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity //OBLIGATOIRE
@Table(name="reservation")
public class Reservation {
	@Id //OBLIGATOIRE
	@GeneratedValue(strategy = GenerationType.IDENTITY)//SEMI-OBLIGATOIRE pour de l'auto-increment
	private Integer id;
	
	private Client client; 
	
	private Passager passager;
	
	private Paiement paiement; 
	
	private Voyage voyage;
	
	
	public Reservation() {
	}


	public Reservation(Integer id, Client client, Passager passager, Paiement paiement, Voyage voyage) {
		super();
		this.id = id;
		this.client = client;
		this.passager = passager;
		this.paiement = paiement;
		this.voyage = voyage;
	}


	public Reservation(Client client, Passager passager, Paiement paiement, Voyage voyage) {
		super();
		this.client = client;
		this.passager = passager;
		this.paiement = paiement;
		this.voyage = voyage;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Client getClient() {
		return client;
	}


	public void setClient(Client client) {
		this.client = client;
	}


	public Passager getPassager() {
		return passager;
	}


	public void setPassager(Passager passager) {
		this.passager = passager;
	}


	public Paiement getPaiement() {
		return paiement;
	}


	public void setPaiement(Paiement paiement) {
		this.paiement = paiement;
	}


	public Voyage getVoyage() {
		return voyage;
	}


	public void setVoyage(Voyage voyage) {
		this.voyage = voyage;
	}


	@Override
	public String toString() {
		return "Reservation [id=" + id + ", client=" + client + ", passager=" + passager + ", paiement=" + paiement
				+ ", voyage=" + voyage + "]";
	}
	
	
	
	
}
