package com.coder.web.rest.test;

import java.net.URI;
import java.util.Base64;
import java.util.Date;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.coder.web.rest.service.Film;


public class TestConsumingApi {

	public static void main(String[] args) {
		
		new TestConsumingApi().getFilms();
		//new TestConsumingApi().getFilmById();
		//new TestConsumingApi().addFilm();
		//new TestConsumingApi().updateFilm("Spring MVC");
		//new TestConsumingApi().deleteFilm("Spring MVC");

	}

	public void getFilms() {
		HttpHeaders headers = getheader();
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://localhost:8080/films";
		HttpEntity<String> httpEntity = new HttpEntity<String>(headers);
		ResponseEntity<Film[]> responseEntity = restTemplate.exchange(url, HttpMethod.GET, httpEntity, Film[].class);
		Film[] film = responseEntity.getBody();
		for (Object object : film) {
			System.out.println(object);
		}
	}
	
	public void getFilmById() {
		HttpHeaders headers = getheader();
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://localhost:8080/films/{id}";
		HttpEntity<String> httpEntity = new HttpEntity<String>(headers);
		ResponseEntity<Film> responseEntity = restTemplate.exchange(url, HttpMethod.GET, httpEntity, Film.class, "MacbookPro");
		Film film = responseEntity.getBody();
		System.out.println(film);
	}
	
	public void addFilm() {
		HttpHeaders headers = getheader();
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://localhost:8080/films/";
		final Film film = new Film("Spring", "Boot", new Date().toString());
		HttpEntity<Film> httpEntity = new HttpEntity<Film>(film, headers);
		URI uri = restTemplate.postForLocation(url, httpEntity);
		System.out.println(uri.getPath());
	}
	
	public void updateFilm(String filmName) {
		HttpHeaders headers = getheader();
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://localhost:8080/films/"+filmName;
		final Film film = new Film("Spring MVC", "Spring Security", "13/05/2019");
		HttpEntity<Film> httpEntity = new HttpEntity<Film>(film, headers);
		restTemplate.put(url, httpEntity);
	}
	
	public void deleteFilm(String filmName) {
		HttpHeaders headers = getheader();
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://localhost:8080/films/{id}";
		HttpEntity<Film> httpEntity = new HttpEntity<Film>(headers);
		restTemplate.exchange(url, HttpMethod.DELETE, httpEntity, Void.class, filmName);
	}
	
	private static HttpHeaders getheader() {
		String credentials = "user:password";
		String encodedCredentials = new String(Base64.getEncoder().encodeToString(credentials.getBytes()));
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.add("Authorization", "Basic " + encodedCredentials);
		return headers;
	}

}
