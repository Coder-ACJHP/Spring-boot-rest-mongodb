package com.coder.web.rest.service;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface FilmRepository extends MongoRepository<Film, String> {
	
	public Film findByName(String name);
	
	public void deleteByName(String name);
}
