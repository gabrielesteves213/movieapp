package br.com.movieappbackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.movieappbackend.model.Movie;
import br.com.movieappbackend.service.MovieServiceImpl;

@RestController
@CrossOrigin("http://localhost:4200/")
@RequestMapping("/api")
public class MovieController {
	
	@Autowired
	private MovieServiceImpl movieService;
	
	@GetMapping("/movies")
	public ResponseEntity<?> getAllMovies(){
		return movieService.getAllMovies();
	}
	
	@GetMapping("/movie/{id}")
	public ResponseEntity<?> getMovieById(@PathVariable(name="id") Long id){
		return movieService.getMovieById(id);
	}
	
	
	@PostMapping("/movies")
	public ResponseEntity<?> saveMovie(@RequestBody Movie movie){
		return movieService.saveMovie(movie);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteMovieById(@PathVariable(name="id") Long id){
		return movieService.deleteMovieById(id);
	}
	
	
	@PutMapping("/update")
	public ResponseEntity<?> updateMovie(@RequestBody Movie movie){
		return movieService.updateMovie(movie);
	}
	
	
	
}
