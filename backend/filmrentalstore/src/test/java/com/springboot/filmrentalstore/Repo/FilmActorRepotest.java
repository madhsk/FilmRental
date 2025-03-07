package com.springboot.filmrentalstore.Repo;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.*;

import com.springboot.filmrentalstore.model.Actor;
import com.springboot.filmrentalstore.model.Film;
import com.springboot.filmrentalstore.model.FilmActor;
import com.springboot.filmrentalstore.model.FilmActorId;
import com.springboot.filmrentalstore.repo.FilmActorRepo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class FilmActorRepoTest {

    @Mock
    private FilmActorRepo filmActorRepo;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testExistsByFilmAndActor_WhenExists() {
        // Arrange
        Film film = new Film();
        film.setFilmId(1L);
        film.setTitle("Inception");

        Actor actor = new Actor();
        actor.setActorId(1L);
        actor.setFirstName("Leonardo DiCaprio");

        when(filmActorRepo.existsByFilmAndActor(film, actor)).thenReturn(true);

        // Act
        boolean exists = filmActorRepo.existsByFilmAndActor(film, actor);

        // Assert
        assertTrue(exists);
        verify(filmActorRepo, times(1)).existsByFilmAndActor(film, actor);
    }

    @Test
    void testExistsByFilmAndActor_WhenDoesNotExist() {
        // Arrange
        Film film = new Film();
        //film.setActorId(2L);
        film.setTitle("Interstellar");

        Actor actor = new Actor();
        actor.setActorId(2L);
        actor.setFirstName("Matthew McConaughey");

        when(filmActorRepo.existsByFilmAndActor(film, actor)).thenReturn(false);

        // Act
        boolean exists = filmActorRepo.existsByFilmAndActor(film, actor);

        // Assert
        assertFalse(exists);
        verify(filmActorRepo, times(1)).existsByFilmAndActor(film, actor);
    }
}
