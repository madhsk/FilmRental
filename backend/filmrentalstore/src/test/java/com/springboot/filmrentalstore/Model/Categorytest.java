package com.springboot.filmrentalstore.Model;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

import com.springboot.filmrentalstore.model.Category;

class Categorytest {

    @Test
    void testDefaultConstructor() {
        // Act
        Category category = new Category();

        // Assert
        assertNotNull(category);
        assertEquals(0, category.getCategory_id());
        assertNull(category.getName());
        assertNull(category.getLast_update());
    }

    @Test
    void testParameterizedConstructor() {
        // Arrange
        long categoryId = 1L;
        String name = "Comedy";
        LocalDateTime lastUpdate = LocalDateTime.now();

        // Act
        Category category = new Category(categoryId, name, lastUpdate);

        // Assert
        assertEquals(categoryId, category.getCategory_id());
        assertEquals(name, category.getName());
        assertEquals(lastUpdate, category.getLast_update());
    }

    @Test
    void testSetCategoryId() {
        // Arrange
        Category category = new Category();
        long categoryId = 2L;

        // Act
        category.setCategory_id(categoryId);

        // Assert
        assertEquals(categoryId, category.getCategory_id());
    }

    @Test
    void testSetName() {
        // Arrange
        Category category = new Category();
        String name = "Horror";

        // Act
        category.setName(name);

        // Assert
        assertEquals(name, category.getName());
    }

    @Test
    void testSetLastUpdate() {
        // Arrange
        Category category = new Category();
        LocalDateTime lastUpdate = LocalDateTime.now();

        // Act
        category.setLast_update(lastUpdate);

        // Assert
        assertEquals(lastUpdate, category.getLast_update());
    }
}
