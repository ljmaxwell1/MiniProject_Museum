package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Artist;

/**  
* @author Tim Ancona - tsancona  
* CIS175 - Spring 2022
* Mar 3, 2022  
*/
public class ArtistHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("museum");
	
	public void insertArtist(Artist a) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(a);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Artist> showAllArtists() {
		EntityManager em = emfactory.createEntityManager();
		List<Artist> allArtists = em.createQuery("SELECT a FROM Artist a").getResultList();
		return allArtists;
	}
}
