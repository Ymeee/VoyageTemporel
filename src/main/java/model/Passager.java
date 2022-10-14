package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;


	@Entity
	@Inheritance(strategy = InheritanceType.SINGLE_TABLE)

	@Table(name="passager")
	public abstract class Passager {
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		protected Integer id;
		
		@Column(columnDefinition = "VARCHAR(35)", nullable = false)
		private String nom;
		
		@Column(length = 30, nullable = false)
		private String prenom;
		private int age;
		
		public Passager() {
		
		}
		public Passager(Integer id, String nom, String prenom, int age) {
		
			this.id = id;
			this.nom = nom;
			this.prenom = prenom;
			this.age = age;
		}
		public Passager( String nom, String prenom, int age) {
			
			this.nom = nom;
			this.prenom = prenom;
			this.age = age;
		}
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
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
		public int getAge() {
			return age;
		}
		public void setAge(int age) {
			this.age = age;
		}
		@Override
		public String toString() {
			return "Passager [nom=" + nom + ", prenom=" + prenom + ", age=" + age + "]";
		}
		
		
		
		
		

}
