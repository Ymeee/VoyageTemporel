package model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

	@Entity
	@Table(name="paiement")

	public class Paiement {
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		protected Integer id;
		private double montant;
		
		
		public Paiement(Integer id, double montant) {
			this.id = id;
			this.montant = montant;
		}
		
		public Paiement( double montant) {
			this.montant = montant;
		}
		public Paiement() {
			
		}
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public double getMontant() {
			return montant;
		}
		public void setMontant(double montant) {
			this.montant = montant;
		}

		@Override
		public String toString() {
			return "Paiement [id=" + id + ", montant=" + montant + "]";
		}
		
		
}
