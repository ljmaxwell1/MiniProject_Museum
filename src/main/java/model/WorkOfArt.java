package model;


import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**  
* @author Tim Ancona - tsancona  
* CIS175 - Spring 2022
* Feb 26, 2022  
*/
@Entity
@Table(name="works_of_art")
public class WorkOfArt {
	@Id
	@GeneratedValue
	@Column(name="ID")
	private int id;
	@Column(name="TITLE")
	private String title;
	@Column(name="MEDIUM")
	private String medium;
	@Column(name="DATE_PUBLISHED")
	private LocalDate datePublished;

	public WorkOfArt() {
		super();
		// TODO Auto-generated constructor stub
	}

	public WorkOfArt(String title, String medium, LocalDate datePublished) {
		super();
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
