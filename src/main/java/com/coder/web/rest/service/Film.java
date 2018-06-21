package com.coder.web.rest.service;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@Document(collection = "Film")
@JsonDeserialize(as=Film.class)
public class Film {

	@Id
	private String Id;
	private String name;
	private String actor;
	private String releaseDate;
	
	public Film() {}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getActor() {
		return actor;
	}

	public void setActor(String actor) {
		this.actor = actor;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	public Film(String name, String actor, String releaseDate) {
		this.name = name;
		this.actor = actor;
		this.releaseDate = releaseDate;
	}

	@Override
	public String toString() {
		return "Film [name=" + name + ", actor=" + actor + ", releaseDate=" + releaseDate + "]";
	}

	
}
