package br.com.movieappbackend.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.movieappbackend.model.Movie;

@Service
public interface MovieService {

	ResponseEntity<?> getAllMovies();
	
	ResponseEntity<?> getMovieById(Long id);
	
	ResponseEntity<?> saveMovie(Movie movie);
	
	ResponseEntity<?> deleteMovieById(Long id);
	
	ResponseEntity<?> updateMovie(Movie movie);
	
}
