package dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import context.Context;
import dao.IDAOMachine;
import model.Machine;

public class DAOMachine implements IDAOMachine{
	
	@Override
	public List<Machine> findAll() {
		EntityManager em = Context.getSingleton().getEmf().createEntityManager();
		List<Machine> confirmations = em.createQuery("from Machine").getResultList();

		em.close();

		return confirmations;
	}

	@Override
	public Machine findById(Integer id) {
	
		EntityManager em = Context.getSingleton().getEmf().createEntityManager();
		Machine c = em.find(Machine.class, id);
		em.close();

		return c;
	}
	
	@Override
	public Machine save(Machine c) {
		
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
		Machine c = em.find(Machine.class, id);

		em.getTransaction().begin();

		em.remove(c);

		em.getTransaction().commit();


		em.close();
	}
	

}
