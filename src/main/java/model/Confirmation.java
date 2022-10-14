package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="confirmation")
public class Confirmation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Integer id;
	
	@Column(length = 300,nullable = false)
	protected String facture;
	
	@Column(length = 300,nullable = false)
	private String confirmationParMail;
	
	public Confirmation() {
	}

	public Confirmation(Integer id, String facture, String confirmationParMail) {
		this.id = id;
		this.facture = facture;
		this.confirmationParMail = confirmationParMail;
	}

	public Confirmation(String facture, String confirmationParMail) {
		this.facture = facture;
		this.confirmationParMail = confirmationParMail;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFacture() {
		return facture;
	}

	public void setFacture(String facture) {
		this.facture = facture;
	}

	public String getConfirmationParMail() {
		return confirmationParMail;
	}

	public void setConfirmationParMail(String confirmationParMail) {
		this.confirmationParMail = confirmationParMail;
	}

	@Override
	public String toString() {
		return "Confirmation [id=" + id + ", facture=" + facture + ", confirmationParMail=" + confirmationParMail + "]";
	}
	

	
}
