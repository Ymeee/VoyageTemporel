package dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import context.Context;
import dao.IDAOAdmin;
import dao.IDAOClient;
import model.Admin;
import model.Client;


public class DAOClient implements IDAOClient{
	
	@Override
	public List<Client> findAll() {
		EntityManager em = Context.getSingleton().getEmf().createEntityManager();
		List<Client> clients = em.createQuery("from Client").getResultList();

		em.close();

		return clients;
	}
	
	
	@Override
	public Client findById(Integer id) {
		EntityManager em = Context.getSingleton().getEmf().createEntityManager();		
		Client m = em.find(Client.class, id);
		em.close();
		return m;
	}

	@Override
	public Client save(Client m) {
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
		Client m = em.find(Client.class, id);
		
		em.getTransaction().begin();

		em.remove(m);

		em.getTransaction().commit();


		em.close();
	}
	
	
}
