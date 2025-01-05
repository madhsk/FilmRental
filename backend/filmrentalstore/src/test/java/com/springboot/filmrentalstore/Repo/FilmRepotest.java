package com.springboot.filmrentalstore.Repo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import com.springboot.filmrentalstore.model.Film;
import com.springboot.filmrentalstore.repo.FilmRepo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class FilmRepoTest {

    @Mock
    private FilmRepo filmRepo;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindFilmByTitle() {
        // Arrange
        String title = "Inception";
        Film film = new Film();
        film.setFilmId(1L);
        film.setTitle(title);

        when(filmRepo.findFilmByTitle(title)).thenReturn(film);

        // Act
        Film result = filmRepo.findFilmByTitle(title);

        // Assert
        assertEquals(title, result.getTitle());
        assertEquals(1L, result.getFilmId());
        verify(filmRepo, times(1)).findFilmByTitle(title);
    }

    @Test
    void testFindFilmByTitle_WhenFilmNotFound() {
        // Arrange
        String title = "Nonexistent Film";
        when(filmRepo.findFilmByTitle(title)).thenReturn(null);

        // Act
        Film result = filmRepo.findFilmByTitle(title);

        // Assert
        assertEquals(null, result);
        verify(filmRepo, times(1)).findFilmByTitle(title);
    }
}
