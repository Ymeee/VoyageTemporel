package dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import context.Context;
import dao.IDAOVoyage;
import model.Voyage;

public class DAOVoyage implements IDAOVoyage{
	
	@Override
	public List<Voyage> findAll() {
		EntityManager em = Context.getSingleton().getEmf().createEntityManager();
		List<Voyage> confirmations = em.createQuery("from Voyage").getResultList();

		em.close();

		return confirmations;
	}

	@Override
	public Voyage findById(Integer id) {
	
		EntityManager em = Context.getSingleton().getEmf().createEntityManager();
		Voyage c = em.find(Voyage.class, id);
		em.close();

		return c;
	}
	
	@Override
	public Voyage save(Voyage c) {
		
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
		Voyage c = em.find(Voyage.class, id);

		em.getTransaction().begin();

		em.remove(c);

		em.getTransaction().commit();


		em.close();
	}
	

}
