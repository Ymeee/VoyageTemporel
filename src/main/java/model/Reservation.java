package model;

import javax.persistence.Column;
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
	
	private double prixReel;
	@Column(nullable = false)
	private Client client; 
	
	private Passager passager;
		
	private Voyage voyage;
	
	
	public Reservation() {
	}


	public Reservation(Integer id, Client client, Passager passager, Voyage voyage, double prixReel) {
		this.id = id;
		this.client = client;
		this.passager = passager;
		this.voyage = voyage;
		this.prixReel = prixReel;
	}


	public Reservation(Client client, Passager passager, Voyage voyage, double prixReel) {
		this.client = client;
		this.passager = passager;
		this.voyage = voyage;
		this.prixReel = prixReel;
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


	public Voyage getVoyage() {
		return voyage;
	}


	public void setVoyage(Voyage voyage) {
		this.voyage = voyage;
	}


	public double getPrixReel() {
		return prixReel;
	}


	public void setPrixReel(double prixReel) {
		this.prixReel = prixReel;
	}


	@Override
	public String toString() {
		return "Reservation [id=" + id + ", prixReel=" + prixReel + ", client=" + client + ", passager=" + passager
				+ ", voyage=" + voyage + "]";
	}

	
	
	
	
	
}
