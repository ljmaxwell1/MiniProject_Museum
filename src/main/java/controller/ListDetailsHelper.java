package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.ListDetails;

/**  
* @author Tim Ancona - tsancona  
* CIS175 - Spring 2022
* Mar 3, 2022  
*/
public class ListDetailsHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("museum");
	
	public void insertNewListDetails(ListDetails ld) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(ld);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<ListDetails> getLists() {
		EntityManager em = emfactory.createEntityManager();
		List<ListDetails> allDetails = em.createQuery("SELECT d FROM ListDetails d").getResultList();
		return allDetails;
	}
}
