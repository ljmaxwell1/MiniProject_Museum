package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.WorkOfArt;

/**  
* @author Tim Ancona - tsancona  
* CIS175 - Spring 2022
* Mar 1, 2022  
*/

/**
 * Modified by:
 *Larry J Maxwell - ljmaxwell1@dmacc.edu
 *CIS175 - Spring 2022
 *Mar 2, 2022
 *
 */
public class WorkOfArtHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("museum");
	
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
	// copied code below
	
	public void deleteName(WorkOfArt toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<WorkOfArt> typedQuery = em.createQuery("select li from WorkOfArt li where li.title = :title and li.medium = :medium",WorkOfArt.class);
		//Substitute parameter with actual data from the toDelete item
		typedQuery.setParameter("title", toDelete.getTitle());
		typedQuery.setParameter("medium", toDelete.getMedium());
		//we only want one result
		typedQuery.setMaxResults(1);
		//get the result and save it into a new list item
		WorkOfArt result = typedQuery.getSingleResult();
		//remove it
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}

	public WorkOfArt searchForItemById(int idToEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		WorkOfArt found = em.find(WorkOfArt.class, idToEdit);
		em.close();
		return found;
	}

	public void updateWorkOfArt(WorkOfArt toUpdate) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toUpdate);
		em.getTransaction().commit();
		em.close();
	}

	
}
