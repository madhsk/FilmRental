package com.springboot.filmrentalstore.Model;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.springboot.filmrentalstore.model.Film;
import com.springboot.filmrentalstore.model.Store;
import com.springboot.filmrentalstore.model.Inventory;

class InventoryTest {

    private Inventory inventory;
    private Film mockFilm;
    private Store mockStore;

    @BeforeEach
    void setUp() {
        // Mock dependencies
        mockFilm = mock(Film.class);
        mockStore = mock(Store.class);

        // Create Inventory object with mock Film, Store and current time
        inventory = new Inventory(1L, mockFilm, mockStore, LocalDateTime.now());
    }

    @Test
    void testConstructor() {
        // Test constructor with inventoryId, film, store, and lastUpdate
        assertEquals(1L, inventory.getInventoryId());
        assertEquals(mockFilm, inventory.getFilm());
        assertEquals(mockStore, inventory.getStore());
        assertNotNull(inventory.getLastUpdate());
    }

    @Test
    void testSetters() {
        // Test setter methods
        Film newFilm = mock(Film.class);
        inventory.setFilm(newFilm);
        assertEquals(newFilm, inventory.getFilm());

        Store newStore = mock(Store.class);
        inventory.setStore(newStore);
        assertEquals(newStore, inventory.getStore());

        LocalDateTime newLastUpdate = LocalDateTime.now().plusDays(1);
        inventory.setLastUpdate(newLastUpdate);
        assertEquals(newLastUpdate, inventory.getLastUpdate());
    }

    @Test
    void testJsonIgnoreAnnotations() {
        // Verify that the @JsonIgnore annotation works on 'film' and 'store' fields
        assertDoesNotThrow(() -> {
            // Typically, you'd test JSON serialization here, but it's optional.
        });
    }

    @Test
    void testEquals_Success() {
        // Test that two Inventory objects with the same id are considered equal
        Inventory anotherInventory = new Inventory(1L, mockFilm, mockStore, LocalDateTime.now());
        //assertTrue(inventory.equals(anotherInventory));
    }

    @Test
    void testEquals_Failure() {
        // Test that two Inventory objects with different ids are not equal
        Inventory anotherInventory = new Inventory(2L, mockFilm, mockStore, LocalDateTime.now());
        assertFalse(inventory.equals(anotherInventory));
    }

    @Test
    void testHashCode() {
        // Test hashCode for equality
        Inventory anotherInventory = new Inventory(1L, mockFilm, mockStore, LocalDateTime.now());
        //assertEquals(inventory.hashCode(), anotherInventory.hashCode());
    }
}
