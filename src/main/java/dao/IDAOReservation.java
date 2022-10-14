package dao;

import java.util.List;

import model.Compte;
import model.Reservation;

public interface IDAOReservation extends IDAO<Reservation,Integer> {

	public Reservation validation(boolean valide);
	
	
}
