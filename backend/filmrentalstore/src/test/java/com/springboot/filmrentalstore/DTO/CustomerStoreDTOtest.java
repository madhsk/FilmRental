package com.springboot.filmrentalstore.DTO;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

import com.springboot.filmrentalstore.model.Address;

class CustomerStoreDTOTest {

    @Test
    void testGetterAndSetter() {
        // Arrange
        CustomerStoreDTO customerStoreDTO = new CustomerStoreDTO();
        Long expectedCustomerId = 1L;
        String expectedFirstName = "John";
        String expectedLastName = "Doe";
        String expectedEmail = "john.doe@example.com";
        boolean expectedActive = true;
        Address expectedAddress = new Address(); // Mock Address object
        LocalDateTime expectedCreateDate = LocalDateTime.now().minusDays(1);
        LocalDateTime expectedLastUpdate = LocalDateTime.now();

        // Act
        customerStoreDTO.setCustomerId(expectedCustomerId);
        customerStoreDTO.setFirstName(expectedFirstName);
        customerStoreDTO.setLastName(expectedLastName);
        customerStoreDTO.setEmail(expectedEmail);
        customerStoreDTO.setActive(expectedActive);
        customerStoreDTO.setAddress(expectedAddress);
        customerStoreDTO.setCreateDate(expectedCreateDate);
        customerStoreDTO.setLastUpdate(expectedLastUpdate);

        // Assert
        assertEquals(expectedCustomerId, customerStoreDTO.getCustomerId());
        assertEquals(expectedFirstName, customerStoreDTO.getFirstName());
        assertEquals(expectedLastName, customerStoreDTO.getLastName());
        assertEquals(expectedEmail, customerStoreDTO.getEmail());
        assertEquals(expectedActive, customerStoreDTO.isActive());
        assertEquals(expectedAddress, customerStoreDTO.getAddress());
        assertEquals(expectedCreateDate, customerStoreDTO.getCreateDate());
        assertEquals(expectedLastUpdate, customerStoreDTO.getLastUpdate());
    }

    @Test
    void testParameterizedConstructor() {
        // Arrange
        Long expectedCustomerId = 1L;
        String expectedFirstName = "John";
        String expectedLastName = "Doe";
        String expectedEmail = "john.doe@example.com";
        boolean expectedActive = true;
        Address expectedAddress = new Address(); // Mock Address object
        LocalDateTime expectedCreateDate = LocalDateTime.now().minusDays(1);
        LocalDateTime expectedLastUpdate = LocalDateTime.now();

        // Act
        CustomerStoreDTO customerStoreDTO = new CustomerStoreDTO(expectedCustomerId, expectedFirstName, 
                expectedLastName, expectedEmail, expectedActive, expectedAddress, expectedCreateDate, expectedLastUpdate);

        // Assert
        assertEquals(expectedCustomerId, customerStoreDTO.getCustomerId());
        assertEquals(expectedFirstName, customerStoreDTO.getFirstName());
        assertEquals(expectedLastName, customerStoreDTO.getLastName());
        assertEquals(expectedEmail, customerStoreDTO.getEmail());
        assertEquals(expectedActive, customerStoreDTO.isActive());
        assertEquals(expectedAddress, customerStoreDTO.getAddress());
        assertEquals(expectedCreateDate, customerStoreDTO.getCreateDate());
        assertEquals(expectedLastUpdate, customerStoreDTO.getLastUpdate());
    }

    @Test
    void testDefaultConstructor() {
        // Act
        CustomerStoreDTO customerStoreDTO = new CustomerStoreDTO();

        // Assert
        assertNull(customerStoreDTO.getCustomerId());
        assertNull(customerStoreDTO.getFirstName());
        assertNull(customerStoreDTO.getLastName());
        assertNull(customerStoreDTO.getEmail());
        assertFalse(customerStoreDTO.isActive());
        assertNull(customerStoreDTO.getAddress());
        assertNull(customerStoreDTO.getCreateDate());
        assertNull(customerStoreDTO.getLastUpdate());
    }
}
