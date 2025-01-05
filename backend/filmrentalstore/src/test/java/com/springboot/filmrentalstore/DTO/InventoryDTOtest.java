package com.springboot.filmrentalstore.DTO;

import com.springboot.filmrentalstore.DTO.InventoryDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class InventoryDTOTest {

    private InventoryDTO inventoryDTO;

    @BeforeEach
    void setUp() {
        // Initialize the InventoryDTO object before each test
        inventoryDTO = new InventoryDTO();
    }

    @Test
    void testSetAndGetInventoryId() {
        // Set the inventoryId and verify it with the getter
        inventoryDTO.setInventoryId(1L);
        assertEquals(1L, inventoryDTO.getInventoryId());
    }

    @Test
    void testSetAndGetFilmId() {
        // Set the filmId and verify it with the getter
        inventoryDTO.setFilmId(2L);
        assertEquals(2L, inventoryDTO.getFilmId());
    }

    @Test
    void testSetAndGetStoreId() {
        // Set the storeId and verify it with the getter
        inventoryDTO.setStoreId(3L);
        assertEquals(3L, inventoryDTO.getStoreId());
    }

    @Test
    void testSetAndGetLastUpdate() {
        // Set the lastUpdate and verify it with the getter
        LocalDateTime now = LocalDateTime.now();
        inventoryDTO.setLastUpdate(now);
        assertEquals(now, inventoryDTO.getLastUpdate());
    }

    @Test
    void testConstructorWithArguments() {
        // Verify the constructor with arguments works as expected
        LocalDateTime now = LocalDateTime.now();
        InventoryDTO newDTO = new InventoryDTO(1L, 2L, 3L, now);

        assertEquals(1L, newDTO.getInventoryId());
        assertEquals(2L, newDTO.getFilmId());
        assertEquals(3L, newDTO.getStoreId());
        assertEquals(now, newDTO.getLastUpdate());
    }

    @Test
    void testDefaultConstructor() {
        // Verify the default constructor works and creates a valid object
        InventoryDTO newDTO = new InventoryDTO();
        assertNotNull(newDTO);
    }
}
