package model;

import java.time.LocalDate;

/**  
* @author Tim Ancona - tsancona  
* CIS175 - Spring 2022
* Feb 26, 2022  
*/
public class WorkOfArt {
	private int id;
	private String title;
	private String medium;
	private LocalDate datePublished;

	public WorkOfArt() {
		super();
		// TODO Auto-generated constructor stub
	}

	public WorkOfArt(int id, String title, String medium, LocalDate datePublished) {
		super();
		this.id = id;
		this.title = title;
		this.medium = medium;
		this.datePublished = datePublished;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMedium() {
		return medium;
	}

	public void setMedium(String medium) {
		this.medium = medium;
	}

	public LocalDate getDatePublished() {
		return datePublished;
	}

	public void setDatePublished(LocalDate datePublished) {
		this.datePublished = datePublished;
	}

	@Override
	public String toString() {
		return "WorkOfArt [id=" + id + ", title=" + title + ", medium=" + medium + ", datePublished=" + datePublished
				+ "]";
	}
}
