package dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;

import context.Context;
import dao.IDAOAdresse;
import model.Adresse;


public class DAOAdresse implements IDAOAdresse{
	
	@Override
	public List<Adresse> findAll() {
		EntityManager em = Context.getSingleton().getEmf().createEntityManager();
		List<Adresse> adresses = em.createQuery("from Adresse").getResultList();

		em.close();

		return adresses;
	}
	
	
	@Override
	public Adresse findById(Integer id) {
		EntityManager em = Context.getSingleton().getEmf().createEntityManager();		
		Adresse m = em.find(Adresse.class, id);
		em.close();
		return m;
	}

	@Override
	public Adresse save(Adresse m) {
		EntityManager em = Context.getSingleton().getEmf().createEntityManager();

		em.getTransaction().begin();

		m=em.merge(m);

		em.getTransaction().commit();


		em.close();

		return m;
	}
	
	@Override
	public void delete(Integer id) {
		EntityManager em = Context.getSingleton().getEmf().createEntityManager();
		Adresse m = em.find(Adresse.class, id);
		
		em.getTransaction().begin();

		em.remove(m);

		em.getTransaction().commit();


		em.close();
	}
	
	
}