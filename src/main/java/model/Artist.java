package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**  
* @author Tim Ancona - tsancona  
* CIS175 - Spring 2022
* Mar 3, 2022  
*/
@Entity
@Table(name="artists")
public class Artist {
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private String style;

	public Artist() {
		super();
	}

	public Artist(int id, String name, String style) {
		super();
		this.id = id;
		this.name = name;
		this.style = style;
	}

	public Artist(String name, String style) {
		super();
		this.name = name;
		this.style = style;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	@Override
	public String toString() {
		return "Artist [id=" + id + ", name=" + name + ", style=" + style + "]";
	}
}
