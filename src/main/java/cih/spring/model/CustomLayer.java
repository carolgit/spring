package cih.spring.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CustomLayer implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private String projection;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProjection() {
		return projection;
	}

	public void setProjection(String projection) {
		this.projection = projection;
	}

	@Override
	public String toString() {
		return "CustomLayer [id=" + id + ", name=" + name + ", projection="
				+ projection + "]";
	}

}
