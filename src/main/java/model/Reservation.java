package model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity //OBLIGATOIRE
@Table(name="reservation")
public class Reservation {
	@Id //OBLIGATOIRE
	@GeneratedValue(strategy = GenerationType.IDENTITY)//SEMI-OBLIGATOIRE pour de l'auto-increment
	private Integer id;
	
	private double prixReel;
	@ManyToOne
	private Client client; 
	
	@ManyToMany
	@JoinTable(name="reservation_passager")
	private List<Passager> passager;
	
	@ManyToOne
	private Voyage voyage;
	
	@Enumerated
	private Guide guide;
	@Column(nullable = false)
	@Enumerated
	private EtatVoyage etatVoyage; 
	
	
	public Reservation() {
	}


	public Reservation(Integer id, Client client, List<Passager> passager, Voyage voyage, double prixReel, EtatVoyage etatVoyage) {
		this.id = id;
		this.client = client;
		this.passager = passager;
		this.voyage = voyage;
		this.prixReel = prixReel;
		this.etatVoyage = etatVoyage;
	}


	public Reservation(Client client, List<Passager> passager, Voyage voyage, double prixReel, EtatVoyage etatVoyage) {
		this.client = client;
		this.passager = passager;
		this.voyage = voyage;
		this.prixReel = prixReel;
		this.etatVoyage = etatVoyage;
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


	public List<Passager> getPassager() {
		return passager;
	}


	public void setPassager(List<Passager> passager) {
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
	
	public Guide getGuide() {
		return guide;
	}

	public void setGuide(Guide guide) {
		this.guide = guide;
	}

	public EtatVoyage getEtatVoyage() {
		return etatVoyage;
	}

	public void setEtatVoyage(EtatVoyage etatVoyage) {
		this.etatVoyage = etatVoyage;
	}
	
	


	@Override
	public String toString() {
		return "Reservation [id=" + id + ", prixReel=" + prixReel + ", client=" + client + ", passager=" + passager
				+ ", voyage=" + voyage + "]";
	}

	
	
	
	
	
}
