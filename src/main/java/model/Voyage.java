package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity //OBLIGATOIRE
@Table(name="voyage")
public class Voyage {
	@Id //OBLIGATOIRE
	@GeneratedValue(strategy = GenerationType.IDENTITY)//SEMI-OBLIGATOIRE pour de l'auto-increment
	private Integer id;

	private Reservation reservation;
	
	private Adresse adresse; 
	
	private Machine machine; 
	
	private Epoque epoque;
	
	private Guide guide;
	
	private EtatVoyage etatVoyage; 
	
	public Voyage(Integer id, Reservation reservation, Adresse adresse, Machine machine, Epoque epoque, Guide guide,
			EtatVoyage etatVoyage) {
		this.id = id;
		this.reservation = reservation;
		this.adresse = adresse;
		this.machine = machine;
		this.epoque = epoque;
		this.guide = guide;
		this.etatVoyage = etatVoyage;
	}

	public Voyage(Reservation reservation, Adresse adresse, Machine machine, Epoque epoque, Guide guide,
			EtatVoyage etatVoyage) {
		this.reservation = reservation;
		this.adresse = adresse;
		this.machine = machine;
		this.epoque = epoque;
		this.guide = guide;
		this.etatVoyage = etatVoyage;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Reservation getReservation() {
		return reservation;
	}

	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public Machine getMachine() {
		return machine;
	}

	public void setMachine(Machine machine) {
		this.machine = machine;
	}

	public Epoque getEpoque() {
		return epoque;
	}

	public void setEpoque(Epoque epoque) {
		this.epoque = epoque;
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
		return "Voyage [id=" + id + ", reservation=" + reservation + ", adresse=" + adresse + ", machine=" + machine
				+ ", epoque=" + epoque + ", guide=" + guide + ", etatVoyage=" + etatVoyage + "]";
	}
	
	
	
}
