package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.WorkOfArt;

/**  
* @author Tim Ancona - tsancona  
* CIS175 - Spring 2022
* Mar 1, 2022  
*/
public class WorkOfArtHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("musuem");
	
	public void insertWorkOfArt(WorkOfArt woa) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(woa);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<WorkOfArt> showAllWorksOfArt() {
		EntityManager em = emfactory.createEntityManager();
		List<WorkOfArt> allWorksOfArt = em.createQuery("SELECT w FROM WorkOfArt w").getResultList();
		return allWorksOfArt;
	}
}
