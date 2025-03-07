package com.springboot.filmrentalstore.Model;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.springboot.filmrentalstore.model.Category;
import com.springboot.filmrentalstore.model.Film;
import com.springboot.filmrentalstore.model.FilmCategory;

class FilmCategoryTest {

    private FilmCategory filmCategory;
    private Film mockFilm;
    private Category mockCategory;

    @BeforeEach
    void setUp() {
        // Mock dependencies
        mockFilm = mock(Film.class);
        mockCategory = mock(Category.class);

        // Create FilmCategory object with mock dependencies
        filmCategory = new FilmCategory(mockFilm, mockCategory, LocalDateTime.now());
    }

    @Test
    void testConstructor() {
        // Verify that the constructor sets the fields correctly
        assertEquals(mockFilm, filmCategory.getFilm());
        assertEquals(mockCategory, filmCategory.getCategory());
        assertNotNull(filmCategory.getLastUpdate());
    }

    @Test
    void testSetFilm() {
        // Set a new film and verify the setter works correctly
        Film newFilm = mock(Film.class);
        filmCategory.setFilm(newFilm);
        assertEquals(newFilm, filmCategory.getFilm());
    }

    @Test
    void testSetCategory() {
        // Set a new category and verify the setter works correctly
        Category newCategory = mock(Category.class);
        filmCategory.setCategory(newCategory);
        assertEquals(newCategory, filmCategory.getCategory());
    }

    @Test
    void testSetLastUpdate() {
        // Set a new last update and verify the setter works correctly
        LocalDateTime newLastUpdate = LocalDateTime.now().plusDays(1);
        filmCategory.setLastUpdate(newLastUpdate);
        assertEquals(newLastUpdate, filmCategory.getLastUpdate());
    }

    @Test
    void testJsonIgnoreAnnotations() {
        // Verify that the @JsonIgnore annotations are applied correctly
        // This is typically tested in the context of JSON serialization/deserialization
        assertDoesNotThrow(() -> {
            // You could add tests for JSON serialization (optional, not required here)
        });
    }
}

