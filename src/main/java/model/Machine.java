package model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@DiscriminatorValue("machine")

public class Machine {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name="DateMachine",nullable = false)
	private LocalDate dateMachine;
	@Column(nullable = false)
	@Enumerated
	private TypeMachine typeMachine;
	@Column(nullable = false)
	@Enumerated
	private EtatMachine etatMachine;

	
	
	public Machine(Integer id, LocalDate dateMachine, TypeMachine typeMachine, EtatMachine etatMachine) {
		this.id = id;
		this.dateMachine = dateMachine;
		this.typeMachine = typeMachine;
		this.etatMachine = etatMachine;
	}
	
	public Machine(LocalDate dateMachine, TypeMachine typeMachine, EtatMachine etatMachine) {
		this.dateMachine = dateMachine;
		this.typeMachine = typeMachine;
		this.etatMachine = etatMachine;
	}
	
	public Machine() {}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public LocalDate getDateMachine() {
		return dateMachine;
	}
	public void setDateMachine(LocalDate dateMachine) {
		this.dateMachine = dateMachine;
	}

	public TypeMachine getTypeMachine() {
		return typeMachine;
	}

	public void setTypeMachine(TypeMachine typeMachine) {
		this.typeMachine = typeMachine;
	}

	public EtatMachine getEtatMachine() {
		return etatMachine;
	}

	public void setEtatMachine(EtatMachine etatMachine) {
		this.etatMachine = etatMachine;
	}
	
	

}
