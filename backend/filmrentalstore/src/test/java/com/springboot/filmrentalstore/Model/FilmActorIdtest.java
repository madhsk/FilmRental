package com.springboot.filmrentalstore.Model;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.springboot.filmrentalstore.model.FilmActorId;

class FilmActorIdTest {

    private FilmActorId filmActorId1;
    private FilmActorId filmActorId2;

    @BeforeEach
    void setUp() {
        // Create FilmActorId instances for testing
        filmActorId1 = new FilmActorId(1L, 100L);
        filmActorId2 = new FilmActorId(1L, 100L);
    }

    @Test
    void testEquals_Success() {
        // The two objects should be equal because they have the same actor and film IDs
        assertTrue(filmActorId1.equals(filmActorId2));
    }

    @Test
    void testEquals_Failure_DifferentActor() {
        // Set different actor in filmActorId2
        filmActorId2.setActor(2L);
        assertFalse(filmActorId1.equals(filmActorId2));
    }

    @Test
    void testEquals_Failure_DifferentFilm() {
        // Set different film in filmActorId2
        filmActorId2.setFilm(200L);
        assertFalse(filmActorId1.equals(filmActorId2));
    }

    @Test
    void testHashCode_EqualObjects() {
        // Since filmActorId1 and filmActorId2 are equal, their hashcodes should be the same
        assertEquals(filmActorId1.hashCode(), filmActorId2.hashCode());
    }

    @Test
    void testHashCode_NotEqualObjects() {
        // Modify one property to make the objects different
        filmActorId2.setFilm(200L);
        assertNotEquals(filmActorId1.hashCode(), filmActorId2.hashCode());
    }

    @Test
    void testConstructor() {
        // Testing the constructor with actor and film IDs
        FilmActorId newFilmActorId = new FilmActorId(5L, 50L);
        assertEquals(5L, newFilmActorId.getActor());
        assertEquals(50L, newFilmActorId.getFilm());
    }

    @Test
    void testSettersAndGetters() {
        // Test setter and getter methods
        filmActorId1.setActor(10L);
        filmActorId1.setFilm(20L);
        assertEquals(10L, filmActorId1.getActor());
        assertEquals(20L, filmActorId1.getFilm());
    }
}

