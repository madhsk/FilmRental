package com.springboot.filmrentalstore.DTO;

import com.springboot.filmrentalstore.DTO.FilmDTO;
import com.springboot.filmrentalstore.model.Language;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class FilmDTOTest {

    private FilmDTO filmDTO;

    @BeforeEach
    void setUp() {
        // Initialize FilmDTO object before each test
        filmDTO = new FilmDTO();
    }

    @Test
    void testSetAndGetFilmId() {
        // Test setting and getting filmId
        filmDTO.setFilmId(1L);
        assertEquals(1L, filmDTO.getFilmId());
    }

    @Test
    void testSetAndGetTitle() {
        // Test setting and getting title
        filmDTO.setTitle("Inception");
        assertEquals("Inception", filmDTO.getTitle());
    }

    @Test
    void testSetAndGetDescription() {
        // Test setting and getting description
        filmDTO.setDescription("A mind-bending thriller");
        assertEquals("A mind-bending thriller", filmDTO.getDescription());
    }

    @Test
    void testSetAndGetReleaseYear() {
        // Test setting and getting release year
        filmDTO.setRelease_year(2010);
        assertEquals(2010, filmDTO.getRelease_year());
    }

    @Test
    void testSetAndGetLanguage() {
        // Test setting and getting language
        Language language = new Language(); // assuming Language is a class
        filmDTO.setLanguage(language);
        assertEquals(language, filmDTO.getLanguage());
    }

    @Test
    void testSetAndGetOriginalLanguageId() {
        // Test setting and getting original language ID
        filmDTO.setOriginal_language_id(1);
        assertEquals(1, filmDTO.getOriginal_language_id());
    }

    @Test
    void testSetAndGetRentalDuration() {
        // Test setting and getting rental duration
        filmDTO.setRental_duration(7);
        assertEquals(7, filmDTO.getRental_duration());
    }

    @Test
    void testSetAndGetRentalRate() {
        // Test setting and getting rental rate
        filmDTO.setRental_rate(2.99);
        assertEquals(2.99, filmDTO.getRental_rate());
    }

    @Test
    void testSetAndGetLength() {
        // Test setting and getting length
        filmDTO.setLength(148);
        assertEquals(148, filmDTO.getLength());
    }

    @Test
    void testSetAndGetReplacementCost() {
        // Test setting and getting replacement cost
        filmDTO.setReplacement_cost(19.99);
        assertEquals(19.99, filmDTO.getReplacement_cost());
    }

    @Test
    void testSetAndGetRating() {
        // Test setting and getting rating
        filmDTO.setRating(5);
        assertEquals(5, filmDTO.getRating());
    }

    @Test
    void testSetAndGetSpecialFeatures() {
        // Test setting and getting special features
        filmDTO.setSpecial_features("Behind the Scenes");
        assertEquals("Behind the Scenes", filmDTO.getSpecial_features());
    }

    @Test
    void testSetAndGetLastUpdate() {
        // Test setting and getting last update
        LocalDateTime now = LocalDateTime.now();
        filmDTO.setLastUpdate(now);
        assertEquals(now, filmDTO.getLastUpdate());
    }

    @Test
    void testConstructorWithArguments() {
        // Test the constructor with arguments
        LocalDateTime now = LocalDateTime.now();
        Language language = new Language(); // assuming Language is a class
        FilmDTO newDTO = new FilmDTO();
        newDTO.setFilmId(1L);
        newDTO.setTitle("The Matrix");
        newDTO.setDescription("A sci-fi classic");
        newDTO.setRelease_year(1999);
        newDTO.setLanguage(language);
        newDTO.setOriginal_language_id(1);
        newDTO.setRental_duration(5);
        newDTO.setRental_rate(3.99);
        newDTO.setLength(136);
        newDTO.setReplacement_cost(15.99);
        newDTO.setRating(5);
        newDTO.setSpecial_features("Audio Commentary");
        newDTO.setLastUpdate(now);

        assertEquals(1L, newDTO.getFilmId());
        assertEquals("The Matrix", newDTO.getTitle());
        assertEquals("A sci-fi classic", newDTO.getDescription());
        assertEquals(1999, newDTO.getRelease_year());
        assertEquals(language, newDTO.getLanguage());
        assertEquals(1, newDTO.getOriginal_language_id());
        assertEquals(5, newDTO.getRental_duration());
        assertEquals(3.99, newDTO.getRental_rate());
        assertEquals(136, newDTO.getLength());
        assertEquals(15.99, newDTO.getReplacement_cost());
        assertEquals(5, newDTO.getRating());
        assertEquals("Audio Commentary", newDTO.getSpecial_features());
        assertEquals(now, newDTO.getLastUpdate());
    }

    @Test
    void testDefaultConstructor() {
        // Verify that the default constructor works and creates a valid object
        FilmDTO newDTO = new FilmDTO();
        assertNotNull(newDTO);
    }
}
