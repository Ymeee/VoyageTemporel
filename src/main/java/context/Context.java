package context;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dao.IDAOCompte;
import dao.IDAOClient;
import dao.IDAOPaiement;
import dao.IDAOAdresse;
import dao.IDAOAdmin;
import dao.IDAOConfirmation;
import dao.IDAOReservation;
import dao.IDAOVoyage;
import dao.IDAOMachine;
import dao.IDAOPassager;

import dao.jpa.DAOCompte;
import dao.jpa.DAOClient;
import dao.jpa.DAOPaiement;
import dao.jpa.DAOAdresse;
import dao.jpa.DAOAdmin;
import dao.jpa.DAOConfirmation;
import dao.jpa.DAOReservation;
import dao.jpa.DAOVoyage;
import dao.jpa.DAOMachine;
import dao.jpa.DAOPassager;

public class Context {

	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("space");
	
	private IDAOAdmin daoAdmin = new DAOAdmin();	
	private IDAOAdresse daoAdresse = new DAOAdresse();	
	private IDAOClient daoClient = new DAOClient();	
	private IDAOCompte daoCompte = new DAOCompte();	
	private IDAOConfirmation daoConfirmation = new DAOConfirmation();
	private IDAOMachine daoMachine = new DAOMachine();	
	private IDAOPaiement daoPaiement = new DAOPaiement();	
	private IDAOPassager daoPassager = new DAOPassager();	
	private IDAOReservation daoReservation = new DAOReservation();	
	private IDAOVoyage daoVoyage = new DAOVoyage();	

	
	private static Context singleton=null;

	private Context() {}
	
	public static Context getSingleton() {
	
		if(singleton==null) 
		{
			singleton=new Context();	
		}
		return singleton;
	}

	
	public IDAOAdmin getDaoAdmin() {
		return daoAdmin;
	}

	public void setDaoAdmin(IDAOAdmin daoAdmin) {
		this.daoAdmin = daoAdmin;
	}

	public IDAOAdresse getDaoAdresse() {
		return daoAdresse;
	}

	public void setDaoAdresse(IDAOAdresse daoAdresse) {
		this.daoAdresse = daoAdresse;
	}

	public IDAOClient getDaoClient() {
		return daoClient;
	}

	public void setDaoClient(IDAOClient daoClient) {
		this.daoClient = daoClient;
	}

	public IDAOCompte getDaoCompte() {
		return daoCompte;
	}

	public void setDaoCompte(IDAOCompte daoCompte) {
		this.daoCompte = daoCompte;
	}
	
	public IDAOPaiement getDaoPaiement() {
		return daoPaiement;
	}

	public void setDaoPaiement(IDAOPaiement daoPaiement) {
		this.daoPaiement = daoPaiement;
	}
	
	public IDAOConfirmation getDaoConfirmation() {
		return daoConfirmation;
	}

	public void setDaoConfirmation(IDAOConfirmation daoConfirmation) {
		this.daoConfirmation = daoConfirmation;
	}

	public IDAOMachine getDaoMachine() {
		return daoMachine;
	}

	public void setDaoMachine(IDAOMachine daoMachine) {
		this.daoMachine = daoMachine;
	}

	public IDAOPassager getDaoPassager() {
		return daoPassager;
	}

	public void setDaoPassager(IDAOPassager daoPassager) {
		this.daoPassager = daoPassager;
	}

	public IDAOReservation getDaoReservation() {
		return daoReservation;
	}

	public void setDaoReservation(IDAOReservation daoReservation) {
		this.daoReservation = daoReservation;
	}

	public IDAOVoyage getDaoVoyage() {
		return daoVoyage;
	}

	public void setDaoVoyage(IDAOVoyage daoVoyage) {
		this.daoVoyage = daoVoyage;
	}

	public EntityManagerFactory getEmf() {
		return emf;
	}


	public void setEmf(EntityManagerFactory emf) {
		this.emf = emf;
	}

	
	
	
	
	
	
}
