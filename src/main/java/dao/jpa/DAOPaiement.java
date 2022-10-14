package dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import context.Context;
import dao.IDAOPaiement;
import model.Paiement;

public class DAOPaiement implements IDAOPaiement{
	
	@Override
	public List<Paiement> findAll() {
		EntityManager em = Context.getSingleton().getEmf().createEntityManager();
		List<Paiement> confirmations = em.createQuery("from Paiement").getResultList();

		em.close();

		return confirmations;
	}

	@Override
	public Paiement findById(Integer id) {
	
		EntityManager em = Context.getSingleton().getEmf().createEntityManager();
		Paiement c = em.find(Paiement.class, id);
		em.close();

		return c;
	}
	
	@Override
	public Paiement save(Paiement c) {
		
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
		Paiement c = em.find(Paiement.class, id);

		em.getTransaction().begin();

		em.remove(c);

		em.getTransaction().commit();


		em.close();
	}
	

}
