package com.springboot.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "animals")
public class Animals {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private long id;
	@Column(name = "image")
	private String image;
	@Column(name = "name")
	private String name;
	@Column(name = "active")
	private String active;
	@Column(name = "bread")
	private String bread;
	
	public Animals() {
		super();
	}
	
	

	public Animals(String image, String name, String active, String bread) {
		super();
		this.image = image;
		this.name = name;
		this.active = active;
		this.bread = bread;
	}



	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public String getBread() {
		return bread;
	}

	public void setBread(String bread) {
		this.bread = bread;
	}


	
	
	
}
