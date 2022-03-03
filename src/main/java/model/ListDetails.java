package model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**  
* @author Tim Ancona - tsancona  
* CIS175 - Spring 2022
* Mar 3, 2022  
*/
@Entity
public class ListDetails {
	@Id
	@GeneratedValue
	private int id;
	private String listName;
	@ManyToOne(cascade=CascadeType.PERSIST)
	private Artist artist;
	@OneToMany(cascade=CascadeType.PERSIST, fetch=FetchType.EAGER)
	private List<WorkOfArt> listOfWorks;

	public ListDetails() {
		super();
	}

	public ListDetails(int id, String listName, Artist artist, List<WorkOfArt> listOfWorks) {
		super();
		this.id = id;
		this.listName = listName;
		this.artist = artist;
		this.listOfWorks = listOfWorks;
	}

	public ListDetails(String listName, Artist artist, List<WorkOfArt> listOfWorks) {
		super();
		this.listName = listName;
		this.artist = artist;
		this.listOfWorks = listOfWorks;
	}

	public ListDetails(String listName, Artist artist) {
		super();
		this.listName = listName;
		this.artist = artist;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getListName() {
		return listName;
	}

	public void setListName(String listName) {
		this.listName = listName;
	}

	public Artist getArtist() {
		return artist;
	}

	public void setArtist(Artist artist) {
		this.artist = artist;
	}

	public List<WorkOfArt> getListOfWorks() {
		return listOfWorks;
	}

	public void setListOfWorks(List<WorkOfArt> listOfWorks) {
		this.listOfWorks = listOfWorks;
	}

	@Override
	public String toString() {
		return "ListDetails [id=" + id + ", listName=" + listName + ", artist=" + artist + ", listOfWorks="
				+ listOfWorks + "]";
	}
}
