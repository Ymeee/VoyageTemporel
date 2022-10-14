package dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import context.Context;
import dao.IDAOPassager;
import model.Passager;

public class DAOPassager implements IDAOPassager {


	@Override
	public List<Passager> findAll() {
		EntityManager em = Context.getSingleton().getEmf().createEntityManager();
		List<Passager> passagers = em.createQuery("from Passager").getResultList();

		em.close();

		return passagers;
	}
	
	@Override
	public Passager findById(Integer id) {
	
		EntityManager em = Context.getSingleton().getEmf().createEntityManager();
		Passager p = em.find(Passager.class, id);
		em.close();

		return p;
	}
	
	@Override
	public Passager save(Passager p) {
		
		EntityManager em = null;
		EntityTransaction tx = null;

		try {
			em = Context.getSingleton().getEmf().createEntityManager();
			tx = em.getTransaction();
			tx.begin();

			p = em.merge(p);

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
		return p;
	}
	
	@Override
	public void delete(Integer id) {
		EntityManager em = Context.getSingleton().getEmf().createEntityManager();
		Passager p = em.find(Passager.class, id);

		em.getTransaction().begin();

		em.remove(p);

		em.getTransaction().commit();


		em.close();
	}
	
}
