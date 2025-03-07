package com.springboot.filmrentalstore.controller;

import com.springboot.filmrentalstore.DTO.*;
import com.springboot.filmrentalstore.exception.*;
import com.springboot.filmrentalstore.model.*;
import com.springboot.filmrentalstore.service.FilmService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/films")
public class FilmController {

	@Autowired
	private FilmService filmService;

	@PostMapping("/post")
	public ResponseEntity<String> addFilm(@Valid @RequestBody FilmDTO filmDTO) throws InvalidInputException {
		filmService.addFilm(filmDTO);
		return ResponseEntity.ok("Record Saved");
	}

	@DeleteMapping("/delete/{film_id}")
	public ResponseEntity<String> deleteFilmById(@PathVariable int film_id) throws ResourceNotFoundException {
		boolean deleted = filmService.deleteFilmById(film_id);
		if (!deleted) {
			throw new ResourceNotFoundException("Film record not found.");
		}
		return ResponseEntity.ok("Film record deleted");
	}
	
	@GetMapping("/filmId/{filmId}")
	public ResponseEntity<FilmDTO> findByFilmId(@PathVariable Long filmId) throws ResourceNotFoundException {
		FilmDTO filmDTO = filmService.findByFilmId(filmId);
		if (filmDTO == null) {
			throw new ResourceNotFoundException("Film with title " + filmId + " not found");
		}
		return ResponseEntity.ok(filmDTO);
	}
 

	@GetMapping
	public List<FilmDTO> getAllFilm() {
		return filmService.getAllFilm();
	}

	@GetMapping("/title/{title}")
	public ResponseEntity<FilmDTO> findByTitle(@PathVariable String title) throws ResourceNotFoundException {
		FilmDTO filmDTO = filmService.findFilmsByTitle(title);
		if (filmDTO == null) {
			throw new ResourceNotFoundException("Film with title " + title + " not found");
		}
		return ResponseEntity.ok(filmDTO);
	}

	@GetMapping("/year/{release_year}")
	public ResponseEntity<List<FilmDTO>> findFilmsByReleaseYear(@PathVariable int release_year)
			throws ResourceNotFoundException {
		List<FilmDTO> filmDTOList = filmService.findFilmsByReleaseYear(release_year);
		if (filmDTOList.isEmpty()) {
			throw new ResourceNotFoundException("No records of films found for " + release_year + " release year");
		}
		return ResponseEntity.ok(filmDTOList);
	}

	@GetMapping("/duration/gt/{rd}")
	public ResponseEntity<List<FilmDTO>> findFilmsWhereRentalDurationIsGreater(@PathVariable int rd)
			throws ResourceNotFoundException {
		List<FilmDTO> filmDTOListByRentalDuration = filmService.findFilmsByRentalDuration(rd);
		if (filmDTOListByRentalDuration.isEmpty()) {
			throw new ResourceNotFoundException("No films found where rental duration is greater than " + rd);
		}
		return ResponseEntity.ok(filmDTOListByRentalDuration);
	}

	@GetMapping("/rate/gt/{rate}")
	public ResponseEntity<List<FilmDTO>> findFilmsWhereRentalRateIsGreater(@PathVariable double rate)
			throws ResourceNotFoundException {
		List<FilmDTO> filmDTOListByRentalRate = filmService.findFilmsWhereRentalRateIsGreater(rate);
		if (filmDTOListByRentalRate.isEmpty()) {
			throw new ResourceNotFoundException("No films found where rental rate is greater than " + rate);
		}
		return ResponseEntity.ok(filmDTOListByRentalRate);
	}

	@GetMapping("/length/gt/{length}")
	public ResponseEntity<List<FilmDTO>> findFilmsWhereLengthIsGreater(@PathVariable int length)
			throws ResourceNotFoundException {
		List<FilmDTO> filmDTOListByLength = filmService.findFilmsWhereLengthIsGreater(length);
		if (filmDTOListByLength.isEmpty()) {
			throw new ResourceNotFoundException("No films found where length is greater than " + length);
		}

		return ResponseEntity.ok(filmDTOListByLength);

	}

	@GetMapping("/duration/lt/{rd}")
	public ResponseEntity<List<FilmDTO>> findFilmsWhereRentalDurationIsLower(@PathVariable int rd)
			throws ResourceNotFoundException {
		List<FilmDTO> filmDTOListByRentalDuration = filmService.findFilmsWhereRentalDurationIsLower(rd);
		if (filmDTOListByRentalDuration.isEmpty()) {
			throw new ResourceNotFoundException("No films found where rental duration is lower than " + rd);
		}

		return ResponseEntity.ok(filmDTOListByRentalDuration);

	}

	@GetMapping("/rate/lt/{rate}")
	public ResponseEntity<List<FilmDTO>> findFilmsWhereRentalRateIsLower(@PathVariable double rate)
			throws ResourceNotFoundException {
		List<FilmDTO> filmDTOListByRentalRate = filmService.findFilmsWhereRateIsLower(rate);
		if (filmDTOListByRentalRate.isEmpty()) {
			throw new ResourceNotFoundException("No films found where rental rate is lower than " + rate);
		}
		return ResponseEntity.ok(filmDTOListByRentalRate);
	}

	@GetMapping("/length/lt/{length}")
	public ResponseEntity<List<FilmDTO>> findFilmsWhereLengthIsLower(@PathVariable int length)
			throws ResourceNotFoundException {
		List<FilmDTO> filmDTOListByLength = filmService.findFilmsWhereLengthIsLower(length);
		if (filmDTOListByLength.isEmpty()) {
			throw new ResourceNotFoundException("No films found where length is greater than " + length);
		}
		return ResponseEntity.ok(filmDTOListByLength);
	}

	@GetMapping("/betweenyear/{from}/{to}")
	public ResponseEntity<List<FilmDTO>> findFilmBetweenYear(@PathVariable int from, @PathVariable int to)
			throws ResourceNotFoundException {
		List<FilmDTO> filmsBetweenYear = filmService.findFilmBetweenYear(from, to);
		if (filmsBetweenYear.isEmpty()) {
			throw new ResourceNotFoundException("No films found between year " + from + " to " + to);
		}
		return ResponseEntity.ok(filmsBetweenYear);
	}

	@GetMapping("/rating/lt/{rating}")
	public ResponseEntity<List<FilmDTO>> findFilmsWhereRatingIsLower(@PathVariable int rating)
			throws ResourceNotFoundException {
		List<FilmDTO> filmsByRating = filmService.findFilmsWhereRatingIsLower(rating);
		if (filmsByRating.isEmpty()) {
			throw new ResourceNotFoundException("No films founds with rating lower than " + rating);
		}
		return ResponseEntity.ok(filmsByRating);
	}

	@GetMapping("/rating/gt/{rating}")
	public ResponseEntity<List<FilmDTO>> findFilmsWhereRatingIsHigher(@PathVariable int rating)
			throws ResourceNotFoundException {
		List<FilmDTO> filmsByRating = filmService.findFilmsWhereRatingIsHigher(rating);
		if (filmsByRating.isEmpty()) {
			throw new ResourceNotFoundException("No films found with rating higher than " + rating);
		}

		return ResponseEntity.ok(filmsByRating);
	}

	@GetMapping("/language/{lang}")
	public ResponseEntity<List<FilmDTO>> findFilmsByLanguage(@PathVariable String lang)
			throws ResourceNotFoundException {
		List<FilmDTO> filmsByLang = filmService.findFilmsByLanguage(lang);
		if (filmsByLang.isEmpty()) {
			throw new ResourceNotFoundException("No film found with langauge " + lang);
		}
		return ResponseEntity.ok(filmsByLang);
	}

	@GetMapping("/countbyyear")
	public ResponseEntity<Map<Integer, Integer>> displayFilmsNumberByYear() {
		Map<Integer, Integer> numberOfFilmsByYear = filmService.displayFilmsNumberByYear();
		return ResponseEntity.ok(numberOfFilmsByYear);
	}

	@GetMapping("/language/all")
	public ResponseEntity<List<Language>> displayAllLanguage(){
		List<Language> allLanguage = filmService.getAllLanguage();
		return ResponseEntity.ok(allLanguage);
	}
	
	@PutMapping("/update/title/{id}")
	public ResponseEntity<FilmDTO> updateTitle(@PathVariable int id, @RequestBody String title)
			throws InvalidInputException {
		FilmDTO updatedFilm = filmService.updateTitle(id, title);

		return ResponseEntity.ok(updatedFilm);
	}

	@PutMapping("/update/releaseyear/{id}")
	public ResponseEntity<FilmDTO> updateReleaseYear(@PathVariable int id, @RequestBody int year)
			throws InvalidInputException {
		FilmDTO updatedFilm = filmService.updateReleaseYear(id, year);
		return ResponseEntity.ok(updatedFilm);
	}

	@PutMapping("/update/rentalduration/{id}")
	public ResponseEntity<FilmDTO> updateRentalDuration(@PathVariable int id, @RequestBody int rental_duration)
			throws InvalidInputException {
		FilmDTO updatedFilm = filmService.updateRentalDuration(id, rental_duration);
		return ResponseEntity.ok(updatedFilm);
	}

	@PutMapping("/update/rentalrate/{id}")
	public ResponseEntity<FilmDTO> updateRentalRate(@PathVariable int id, @RequestBody int rental_rate)
			throws InvalidInputException {
		FilmDTO updatedFilm = filmService.updateRentalRate(id, rental_rate);
		return ResponseEntity.ok(updatedFilm);
	}

	@PutMapping("/update/rating/{id}")
	public ResponseEntity<FilmDTO> updateRating(@PathVariable long id, @RequestBody int rating)
			throws InvalidInputException {
		FilmDTO updatedFilm = filmService.updateRating(id, rating);
		return ResponseEntity.ok(updatedFilm);
	}

	@PutMapping("/update/language/{id}")
	public ResponseEntity<FilmDTO> updateLanguage(@PathVariable int id, @RequestBody int lang_id)
			throws InvalidInputException {
		FilmDTO updatedFilm = filmService.updateLanguage(id, lang_id);
		return ResponseEntity.ok(updatedFilm);
	}

	@PutMapping("/{filmId}/actors")
	public ResponseEntity<String> assignActorsToFilm(@PathVariable Long filmId, @RequestBody Collection<Long> actorIds)
			throws InvalidInputException {
		filmService.assignActorsToFilm(filmId, actorIds);
		return ResponseEntity.ok("Actors assigned to film successfully");
	}

	@PutMapping("/update/category/{id}")
	public ResponseEntity<FilmCategory> updateCategory(@PathVariable long id, @RequestBody long category_id)
			throws InvalidInputException {
		FilmCategory updatedFilm = filmService.updateCategory(id, category_id);
		return ResponseEntity.ok(updatedFilm);
	}
}
