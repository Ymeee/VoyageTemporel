package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import context.Context;
import dao.IDAOAdmin;
import model.Admin;


public class DAOAdmin implements IDAOAdmin{
	
	@Override
	public List<Admin> findAll() {
		EntityManager em = Context.getSingleton().getEmf().createEntityManager();
		List<Admin> admins = em.createQuery("from Admin").getResultList();

		em.close();

		return admins;
	}
	
	
	@Override
	public Admin findById(Integer id) {
		EntityManager em = Context.getSingleton().getEmf().createEntityManager();		
		Admin m = em.find(Admin.class, id);
		em.close();
		return m;
	}

	@Override
	public Admin save(Admin m) {
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
		Admin m = em.find(Admin.class, id);
		
		em.getTransaction().begin();

		em.remove(m);

		em.getTransaction().commit();


		em.close();
	}
	
	
}
