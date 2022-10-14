package model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
@DiscriminatorValue("client")
public class Client {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String login;
	private String password;
	private String nom;
	private String prenom;
	private int tel;
	private String mail;
	private LocalDate anniversaire;
	
	@OneToMany(mappedBy="client")
	private List<Reservation> reservation;
	
	@OneToOne
	private Adresse adresse;
	
	public Client() {
	}

	public Client(Integer id, String login, String password, String nom, String prenom, int tel, String mail,
			LocalDate anniversaire) {
		this.id = id;
		this.login = login;
		this.password = password;
		this.nom = nom;
		this.prenom = prenom;
		this.tel = tel;
		this.mail = mail;
		this.anniversaire = anniversaire;
	}

	@Override
	public String toString() {
		return "Client [id=" + id + ", login=" + login + ", password=" + password + ", nom=" + nom + ", prenom="
				+ prenom + ", tel=" + tel + ", mail=" + mail + ", anniversaire=" + anniversaire + ", reservation="
				+ reservation + ", adresse=" + adresse + "]";
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

	public int getTel() {
		return tel;
	}

	public void setTel(int tel) {
		this.tel = tel;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public LocalDate getAnniversaire() {
		return anniversaire;
	}

	public void setAnniversaire(LocalDate anniversaire) {
		this.anniversaire = anniversaire;
	}

	public List<Reservation> getReservation() {
		return reservation;
	}

	public void setReservation(List<Reservation> reservation) {
		this.reservation = reservation;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}
	
	
	
	

}
