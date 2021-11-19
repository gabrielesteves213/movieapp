package br.com.movieappbackend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.movieappbackend.model.Movie;
import br.com.movieappbackend.repository.MovieRepository;

@Service
public class MovieServiceImpl implements MovieService {

	@Autowired
	private MovieRepository movieRepository;

	@Override
	public ResponseEntity<?> getAllMovies() {
		List<Movie> allMoviesList = movieRepository.findAll();

		return new ResponseEntity<>(allMoviesList, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> getMovieById(Long id) {
		Movie movieById = movieRepository.findById(id).get();

		if (movieById == null || movieById.getId() == null) {
			return errorResponse();
		}

		return new ResponseEntity<>(movieById, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> saveMovie(Movie movieToSave) {
		Movie movie = movieRepository.save(movieToSave);

		if (movie == null || movie.getId() == null) {
			return errorResponse();
		}
		return new ResponseEntity<>(movie, HttpStatus.OK);

	}

	@Override
	public ResponseEntity<?> deleteMovieById(Long id) {
		movieRepository.deleteById(id);
		
		
		return new ResponseEntity<>("deleted",HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> updateMovie(Movie movie) {
		Movie movieUpdate = movieRepository.saveAndFlush(movie);
		
		if(movieUpdate==null||movieUpdate.getId()==null) {
			return errorResponse();
		}
		
		return new ResponseEntity<>(movieUpdate,HttpStatus.OK);
	}

	private ResponseEntity<String> errorResponse() {
		return new ResponseEntity<String>("Something occured bad", HttpStatus.BAD_REQUEST);
	}

}
