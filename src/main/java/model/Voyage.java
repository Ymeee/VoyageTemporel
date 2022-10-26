package model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Embedded;
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

	@Column(nullable = false)
	private Reservation reservation;
	
	@Embedded
	private Adresse adresse; 
	@Column(nullable = false)
	private Machine machine; 
	@Column(nullable = false)
	private Epoque epoque;
	
	private Guide guide;
	@Column(nullable = false)
	private EtatVoyage etatVoyage; 
	@Column(nullable = false)
	private LocalDateTime dateDepart;
	@Column(nullable = false)
	private LocalDateTime dateArrivee;
	@Column(nullable = false)
	private LocalDateTime dateRetour;
	@Column(nullable = false)
	private double prix; 
	
	public Voyage() {
	}

	public Voyage(Integer id, Reservation reservation, Adresse adresse, Machine machine, Epoque epoque,
			EtatVoyage etatVoyage, LocalDateTime dateDepart, LocalDateTime dateArrivee, LocalDateTime dateRetour,
			double prix) {
		this.id = id;
		this.reservation = reservation;
		this.adresse = adresse;
		this.machine = machine;
		this.epoque = epoque;
		this.etatVoyage = etatVoyage;
		this.dateDepart = dateDepart;
		this.dateArrivee = dateArrivee;
		this.dateRetour = dateRetour;
		this.prix = prix;
	}

	public Voyage(Reservation reservation, Adresse adresse, Machine machine, Epoque epoque,
			EtatVoyage etatVoyage, LocalDateTime dateDepart, LocalDateTime dateArrivee, LocalDateTime dateRetour,
			double prix) {
		this.reservation = reservation;
		this.adresse = adresse;
		this.machine = machine;
		this.epoque = epoque;
		this.etatVoyage = etatVoyage;
		this.dateDepart = dateDepart;
		this.dateArrivee = dateArrivee;
		this.dateRetour = dateRetour;
		this.prix = prix;
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

	public LocalDateTime getDateDepart() {
		return dateDepart;
	}

	public void setDateDepart(LocalDateTime dateDepart) {
		this.dateDepart = dateDepart;
	}

	public LocalDateTime getDateArrivee() {
		return dateArrivee;
	}

	public void setDateArrivee(LocalDateTime dateArrivee) {
		this.dateArrivee = dateArrivee;
	}

	public LocalDateTime getDateRetour() {
		return dateRetour;
	}

	public void setDateRetour(LocalDateTime dateRetour) {
		this.dateRetour = dateRetour;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	@Override
	public String toString() {
		return "Voyage [id=" + id + ", reservation=" + reservation + ", adresse=" + adresse + ", machine=" + machine
				+ ", epoque=" + epoque + ", guide=" + guide + ", etatVoyage=" + etatVoyage + ", dateDepart="
				+ dateDepart + ", dateArrivee=" + dateArrivee + ", dateRetour=" + dateRetour + ", prix=" + prix + "]";
	}
	
	
	
	
	
	
}
