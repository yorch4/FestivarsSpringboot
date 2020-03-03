package com.festivars.core.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "festival")
public class Festival {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "name")
	private String name;
	@Column(name = "description")
	private String description;
	@Column(name = "capacity")
	private int capacity;
	@Column(name = "allowed_age")
	private int allowed_age;
	@Column(name = "date")
	private Date date;
	@Column(name = "photo")
	private String photo;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public int getAllowed_age() {
		return allowed_age;
	}
	public void setAllowedAge(int allowed_age) {
		this.allowed_age = allowed_age;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public Festival(String name, String description, int capacity, int allowed_age, Date date, String photo) {
		super();
		this.name = name;
		this.description = description;
		this.capacity = capacity;
		this.allowed_age = allowed_age;
		this.date = date;
		this.photo = photo;
	}
	public Festival() {
		super();
	}
	public Festival(int id, String name, String description, int capacity, int allowed_age, Date date, String photo) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.capacity = capacity;
		this.allowed_age = allowed_age;
		this.date = date;
		this.photo = photo;
	}
	
	
}
