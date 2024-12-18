package com.springboot.filmrentalstore.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.springboot.filmrentalstore.model.*;
@Repository
public interface FilmDAO extends JpaRepository<Film,Integer>{
	@Query("SELECT f FROM Film f WHERE f.releaseYear = ?1")
	List<Film> getFilmsByYear(int year);

	@Query("SELECT f FROM Film f WHERE f.length > ?1")
	List<Film> getFilmsByDurationGreaterThan(int duration);

	@Query("SELECT f FROM Film f WHERE f.length < ?1")
	List<Film> getFilmsByDurationLesserThan(int duration);

	@Query("SELECT f FROM Film f WHERE f.rentalRate < ?1")
	List<Film> getFilmsByRateLesserThan(int rate);

	@Query("SELECT f FROM Film f WHERE f.rentalRate > ?1")
	List<Film> getFilmsByRateGreaterThan(int rate);

	@Query("SELECT f FROM Film f WHERE f.length > ?1")
	List<Film> getFilmsByLengthGreaterThan(int length);

	@Query("SELECT f FROM Film f WHERE f.length < ?1")
	List<Film> getFilmsByLengthLesserThan(int length);

	@Query("SELECT f FROM Film f WHERE f.releaseYear BETWEEN ?1 AND ?2")
	List<Film> getFilmsBetweenYears(int fromYear, int toYear);

	@Query("SELECT f FROM Film f WHERE f.rating < ?1")
	List<Film> getFilmsByRatingLesserThan(String rating);

	@Query("SELECT f FROM Film f WHERE f.rating > ?1")
	List<Film> getFilmsByRatingGreaterThan(String rating);

	@Query("SELECT f FROM Film f WHERE f.language = ?1")
	List<Film> getFilmsByLanguage(String language);

	List<Film> findByTitleContainingIgnoreCase(String title);

	@Query("SELECT f FROM Film f")
	List<Film> getAllFilms();
}
