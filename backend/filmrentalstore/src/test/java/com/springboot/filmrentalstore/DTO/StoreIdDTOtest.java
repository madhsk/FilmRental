package com.springboot.filmrentalstore.DTO;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class StoreIdDTOTest {

    @Test
    void testConstructorAndGetterMethods() {
        // Arrange
        Long expectedStoreId = 1L;
        String expectedPhone = "1234567890";

        // Act
        StoreIdDTO storeIdDTO = new StoreIdDTO(expectedStoreId, expectedPhone);

        // Assert
        assertEquals(expectedStoreId, storeIdDTO.getStoreId());
        assertEquals(expectedPhone, storeIdDTO.getPhone());
    }

    @Test
    void testSetterMethods() {
        // Arrange
        StoreIdDTO storeIdDTO = new StoreIdDTO(null, null);
        Long expectedStoreId = 2L;
        String expectedPhone = "9876543210";

        // Act
        storeIdDTO.setStoreId(expectedStoreId);
        storeIdDTO.setPhone(expectedPhone);

        // Assert
        assertEquals(expectedStoreId, storeIdDTO.getStoreId());
        assertEquals(expectedPhone, storeIdDTO.getPhone());
    }
}
