package com.springboot.filmrentalstore.Repo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.util.Optional;

import com.springboot.filmrentalstore.model.Category;
import com.springboot.filmrentalstore.repo.CategoryRepo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class CategoryRepoTest {

    @Mock
    private CategoryRepo categoryRepo;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindById() {
        // Arrange
        Long categoryId = 1L;
        Category category = new Category();
//        category.setId(categoryId);
        category.setName("Action");

        when(categoryRepo.findById(categoryId)).thenReturn(Optional.of(category));

        // Act
        Optional<Category> result = categoryRepo.findById(categoryId);

        // Assert
//        assertEquals(categoryId, result.get().getId());
        assertEquals("Action", result.get().getName());
        verify(categoryRepo, times(1)).findById(categoryId);
    }
}
