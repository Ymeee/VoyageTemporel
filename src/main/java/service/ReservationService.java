package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import exception.ReservationException;
import exception.VoyageException;
import exception.IdException;
import model.Reservation;
import repository.ReservationRepository;

@Service
public class ReservationService {

	@Autowired
	private ReservationRepository reservationRepo;
	
	public List<Reservation> findAll() {
		return reservationRepo.findAll();
	}

	public Reservation findById(Integer id) {
		return reservationRepo.findById(id).orElseThrow(IdException::new);
	}
	
	public Reservation create(Reservation reservation) {
		if (reservation.getId() != null) {
			throw new ReservationException("reservation deja dans la base");
		}
		return save(reservation);

	}

	public Reservation update(Reservation reservation) {
		if (reservation.getId() == null || !reservationRepo.existsById(reservation.getId())) {
			throw new IdException();
		}
		return save(reservation);
	}

	private Reservation save(Reservation reservation) {
		if (reservation.getClient() == null) {
			throw new ReservationException("probleme client");
		}
		if (reservation.getEtatVoyage() == null) {
			throw new ReservationException("probleme voyage");
		}
		return reservationRepo.save(reservation);
	}

	public void delete(Reservation reservation) {
		reservationRepo.delete(reservation);
	}

	public void deleteById(Integer id) {
		reservationRepo.deleteById(id);
	}
}
