package br.com.movieappbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.movieappbackend.model.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long>{

}
