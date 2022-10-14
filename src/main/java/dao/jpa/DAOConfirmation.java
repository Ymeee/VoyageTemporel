package dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import context.Context;
import dao.IDAOConfirmation;
import model.Compte;
import model.Confirmation;

public class DAOConfirmation implements IDAOConfirmation {
	
	@Override
	public List<Confirmation> findAll() {
		EntityManager em = Context.getSingleton().getEmf().createEntityManager();
		List<Confirmation> confirmations = em.createQuery("from Confirmation").getResultList();

		em.close();

		return confirmations;
	}

	@Override
	public Confirmation findById(Integer id) {
	
		EntityManager em = Context.getSingleton().getEmf().createEntityManager();
		Confirmation c = em.find(Confirmation.class, id);
		em.close();

		return c;
	}
	
	@Override
	public Confirmation save(Confirmation c) {
		
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
		Confirmation c = em.find(Confirmation.class, id);

		em.getTransaction().begin();

		em.remove(c);

		em.getTransaction().commit();


		em.close();
	}
	
}
