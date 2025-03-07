package com.springboot.filmrentalstore.Model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.springboot.filmrentalstore.model.FilmCategoryId;

class FilmCategoryIdtest {

    private FilmCategoryId filmCategoryId1;
    private FilmCategoryId filmCategoryId2;

    @BeforeEach
    void setUp() {
        // Initialize FilmCategoryId instances with sample values
        filmCategoryId1 = new FilmCategoryId(1L, 100L);
        filmCategoryId2 = new FilmCategoryId(1L, 100L);
    }

    @Test
    void testConstructor() {
        // Test the constructor
        FilmCategoryId newFilmCategoryId = new FilmCategoryId(2L, 200L);
        assertEquals(2L, newFilmCategoryId.getCategory());
        assertEquals(200L, newFilmCategoryId.getFilm());
    }

    @Test
    void testSetCategory() {
        // Set a new category and check if it updates correctly
        filmCategoryId1.setCategory(10L);
        assertEquals(10L, filmCategoryId1.getCategory());
    }

    @Test
    void testSetFilm() {
        // Set a new film and check if it updates correctly
        filmCategoryId1.setFilm(200L);
        assertEquals(200L, filmCategoryId1.getFilm());
    }

    @Test
    void testEquals_Success() {
        // The two FilmCategoryId objects should be equal since their category and film are the same
        assertTrue(filmCategoryId1.equals(filmCategoryId2));
    }

    @Test
    void testEquals_Failure_DifferentCategory() {
        // Change the category to make the objects different
        filmCategoryId2.setCategory(2L);
        assertFalse(filmCategoryId1.equals(filmCategoryId2));
    }

    @Test
    void testEquals_Failure_DifferentFilm() {
        // Change the film to make the objects different
        filmCategoryId2.setFilm(200L);
        assertFalse(filmCategoryId1.equals(filmCategoryId2));
    }

    @Test
    void testHashCode_EqualObjects() {
        // Verify that two equal FilmCategoryId objects have the same hash code
        assertEquals(filmCategoryId1.hashCode(), filmCategoryId2.hashCode());
    }

    @Test
    void testHashCode_NotEqualObjects() {
        // Change the category of filmCategoryId2 to make the objects different
        filmCategoryId2.setCategory(2L);
        assertNotEquals(filmCategoryId1.hashCode(), filmCategoryId2.hashCode());
    }
}
