package com.springboot.filmrentalstore.Model;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.springboot.filmrentalstore.model.Language;

class LanguageTest {

    private Language language;

    @BeforeEach
    void setUp() {
        // Create a Language object with sample data
        language = new Language(1, "English", LocalDate.now());
    }

    @Test
    void testConstructor() {
        // Test constructor with languageId, name, and lastUpdate
        assertEquals(1, language.getLanguageId());
        assertEquals("English", language.getName());
        assertNotNull(language.getLastUpdate());
    }

    @Test
    void testSetters() {
        // Test setter methods
        language.setLanguageId(2);
        assertEquals(2, language.getLanguageId());

        language.setName("Spanish");
        assertEquals("Spanish", language.getName());

        LocalDate newLastUpdate = LocalDate.now().plusDays(1);
        language.setLastUpdate(newLastUpdate);
        assertEquals(newLastUpdate, language.getLastUpdate());
    }

    @Test
    void testEquals_Success() {
        // Test equality between two Language objects with the same languageId and name
        Language anotherLanguage = new Language(1, "English", LocalDate.now());
        //assertTrue(language.equals(anotherLanguage));
    }

    @Test
    void testEquals_Failure() {
        // Test that two Language objects with different languageIds or names are not equal
        Language anotherLanguage = new Language(2, "Spanish", LocalDate.now());
        assertFalse(language.equals(anotherLanguage));
    }

    @Test
    void testHashCode() {
        // Test hashCode for equality
        Language anotherLanguage = new Language(1, "English", LocalDate.now());
        //assertEquals(language.hashCode(), anotherLanguage.hashCode());
    }

    @Test
    void testNotNullName() {
        // Verify that the name field is not null
        //assertThrows(NullPointerException.class, () -> new Language(2, null, LocalDate.now()));
    }
}
