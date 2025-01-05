package com.springboot.filmrentalstore.DTO;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StoreCreateDTOTest {

    @Test
    void testGetterAndSetter() {
        // Arrange
        StoreCreateDTO storeCreateDTO = new StoreCreateDTO();
        Long expectedAddressId = 1L;

        // Act
        storeCreateDTO.setAddressId(expectedAddressId);

        // Assert
        assertEquals(expectedAddressId, storeCreateDTO.getAddressId());
    }

    @Test
    void testDefaultConstructor() {
        // Act
        StoreCreateDTO storeCreateDTO = new StoreCreateDTO();

        // Assert
        assertNull(storeCreateDTO.getAddressId());
    }
}
