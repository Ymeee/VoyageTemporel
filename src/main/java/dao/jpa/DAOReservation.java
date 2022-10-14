package dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import context.Context;
import dao.IDAOReservation;
import model.Reservation;

public class DAOReservation implements IDAOReservation{
	
	@Override
	public List<Reservation> findAll() {
		EntityManager em = Context.getSingleton().getEmf().createEntityManager();
		List<Reservation> confirmations = em.createQuery("from Reservation").getResultList();

		em.close();

		return confirmations;
	}

	@Override
	public Reservation findById(Integer id) {
	
		EntityManager em = Context.getSingleton().getEmf().createEntityManager();
		Reservation c = em.find(Reservation.class, id);
		em.close();

		return c;
	}
	
	@Override
	public Reservation save(Reservation c) {
		
		EntityManager em = null;
		EntityTransaction tx = null;

		try {
			em = Context.getSingleton().getEmf().createEntityManager();
			tx = em.getTransaction();
			tx.begin();

			c = em.merge(c);

			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
		} finally {
			if (em != null) {
				em.close();
			}
		}

		return c;
	}
	
	@Override
	public void delete(Integer id) {
		EntityManager em = Context.getSingleton().getEmf().createEntityManager();
		Reservation c = em.find(Reservation.class, id);

		em.getTransaction().begin();

		em.remove(c);

		em.getTransaction().commit();


		em.close();
	}
	

}
