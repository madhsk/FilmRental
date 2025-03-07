package com.springboot.filmrentalstore.Repo;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.*;

import com.springboot.filmrentalstore.model.Category;
import com.springboot.filmrentalstore.model.Film;
import com.springboot.filmrentalstore.model.FilmCategory;
import com.springboot.filmrentalstore.model.FilmCategoryId;
import com.springboot.filmrentalstore.repo.FilmCategoryRepo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

class FilmCategoryRepoTest {

    @Mock
    private FilmCategoryRepo filmCategoryRepo;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testExistsByFilmAndCategory_WhenExists() {
        // Arrange
        Film film = new Film();
        film.setFilmId(1L);
        film.setTitle("Inception");

        Category category = new Category();
        //category.setFilmId(1L);
        category.setName("Sci-Fi");

        when(filmCategoryRepo.existsByFilmAndCategory(Optional.of(film), Optional.of(category)))
            .thenReturn(true);

        // Act
        boolean exists = filmCategoryRepo.existsByFilmAndCategory(Optional.of(film), Optional.of(category));

        // Assert
        assertTrue(exists);
        verify(filmCategoryRepo, times(1)).existsByFilmAndCategory(Optional.of(film), Optional.of(category));
    }

    @Test
    void testExistsByFilmAndCategory_WhenDoesNotExist() {
        // Arrange
        Film film = new Film();
        film.setFilmId(2L);
        film.setTitle("Interstellar");

        Category category = new Category();
        //category.setFilmId(2L);
        category.setName("Drama");

        when(filmCategoryRepo.existsByFilmAndCategory(Optional.of(film), Optional.of(category)))
            .thenReturn(false);

        // Act
        boolean exists = filmCategoryRepo.existsByFilmAndCategory(Optional.of(film), Optional.of(category));

        // Assert
        assertFalse(exists);
        verify(filmCategoryRepo, times(1)).existsByFilmAndCategory(Optional.of(film), Optional.of(category));
    }
}
