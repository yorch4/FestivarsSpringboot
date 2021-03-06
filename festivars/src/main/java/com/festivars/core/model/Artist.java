package com.festivars.core.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "artist")
public class Artist {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "alias", unique = true)
	private String alias;
	@Column(name = "description")
	private String description;
	@Column(name = "gender")
	private String gender;
	@Column(name = "age")
	private int age;
	@Column(name = "nacionality")
	private String nacionality;
	@Column(name = "photo")
	private String photo;
	
	@ManyToMany
	@JoinTable(
			name = "festival_artist", 
			joinColumns = @JoinColumn(name="id_artist"),
			inverseJoinColumns = @JoinColumn(name="id_festival")
			)
	private List<Festival> festivals;
	
	public Artist() {
		super();
	}

	public Artist(String alias, String description, String gender, int age, String nacionality, String photo) {
		super();
		this.alias = alias;
		this.description = description;
		this.gender = gender;
		this.age = age;
		this.nacionality = nacionality;
		this.photo = photo;
	}

	public Artist(int id, String alias, String description, String gender, int age, String nacionality, String photo) {
		super();
		this.id = id;
		this.alias = alias;
		this.description = description;
		this.gender = gender;
		this.age = age;
		this.nacionality = nacionality;
		this.photo = photo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getNacionality() {
		return nacionality;
	}

	public void setNacionality(String nacionality) {
		this.nacionality = nacionality;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public List<Festival> getFestivals() {
		return festivals;
	}

	public void addFestival(Festival festival){
        if(this.festivals == null){
            this.festivals = new ArrayList<>();
        }
        
        this.festivals.add(festival);
    }
	


}
