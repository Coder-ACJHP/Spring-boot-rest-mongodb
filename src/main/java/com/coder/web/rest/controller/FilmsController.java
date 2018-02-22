package com.coder.web.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.coder.web.rest.service.Film;
import com.coder.web.rest.service.FilmRepository;

@RestController
public class FilmsController {

	@Autowired
	private FilmRepository filmRepository;
	
	@GetMapping("/films")
	public List<Film> sayHello() {
		return filmRepository.findAll();
	}
	
	@GetMapping("/films/{id}")
	public Film getFilm(@PathVariable String id) {
		return filmRepository.findByName(id);
	}
	
	@PostMapping("/films")
	public void addFilm(@RequestBody Film film) {
		filmRepository.save(film);
	}
	
	@PutMapping("/films/{id}")
	public void updateFilm(@RequestBody Film theFilm, @PathVariable String id) {
		filmRepository.save(theFilm);
	}

	@DeleteMapping("films/{id}")
	public void deleteFilm(@PathVariable("id") String theId) {
		filmRepository.deleteByName(theId);
	}
}
