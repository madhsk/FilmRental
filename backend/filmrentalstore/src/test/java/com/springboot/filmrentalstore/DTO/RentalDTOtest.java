package com.springboot.filmrentalstore.DTO;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

import com.springboot.filmrentalstore.model.*;

class RentalDTOTest {

    @Test
    void testGetterAndSetter() {
        // Arrange
        RentalDTO rentalDTO = new RentalDTO();
        Long expectedRentalId = 1L;
        LocalDateTime expectedRentalDate = LocalDateTime.now().minusDays(1);
        Inventory expectedInventory = new Inventory(); // Mocked Inventory object
        Customer expectedCustomer = new Customer(); // Mocked Customer object
        LocalDateTime expectedReturnDate = LocalDateTime.now().plusDays(1);
        Staff expectedStaff = new Staff(); // Mocked Staff object
        LocalDateTime expectedLastUpdate = LocalDateTime.now();

        // Act
        rentalDTO.setRentalId(expectedRentalId);
        rentalDTO.setRentalDate(expectedRentalDate);
        rentalDTO.setInventory(expectedInventory);
        rentalDTO.setCustomer(expectedCustomer);
        rentalDTO.setReturnDate(expectedReturnDate);
        rentalDTO.setStaff(expectedStaff);
        rentalDTO.setLastUpdate(expectedLastUpdate);

        // Assert
        assertEquals(expectedRentalId, rentalDTO.getRentalId());
        assertEquals(expectedRentalDate, rentalDTO.getRentalDate());
        assertEquals(expectedInventory, rentalDTO.getInventory());
        assertEquals(expectedCustomer, rentalDTO.getCustomer());
        assertEquals(expectedReturnDate, rentalDTO.getReturnDate());
        assertEquals(expectedStaff, rentalDTO.getStaff());
        assertEquals(expectedLastUpdate, rentalDTO.getLastUpdate());
    }

    @Test
    void testDefaultConstructor() {
        // Act
        RentalDTO rentalDTO = new RentalDTO();

        // Assert
        assertNull(rentalDTO.getRentalId());
        assertNull(rentalDTO.getRentalDate());
        assertNull(rentalDTO.getInventory());
        assertNull(rentalDTO.getCustomer());
        assertNull(rentalDTO.getReturnDate());
        assertNull(rentalDTO.getStaff());
        assertNull(rentalDTO.getLastUpdate());
    }

    @Test
    void testValidationConstraints() {
        // Arrange
        RentalDTO rentalDTO = new RentalDTO();
        rentalDTO.setRentalDate(LocalDateTime.now().plusDays(1)); // Future date for invalid test
        rentalDTO.setReturnDate(LocalDateTime.now().minusDays(1)); // Past date for invalid test
        rentalDTO.setLastUpdate(LocalDateTime.now().plusDays(1)); // Future date for invalid test

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            if (rentalDTO.getRentalDate().isAfter(LocalDateTime.now())) {
                throw new IllegalArgumentException("Rental date cannot be in the future");
            }
        });

        assertThrows(IllegalArgumentException.class, () -> {
            if (rentalDTO.getReturnDate().isBefore(LocalDateTime.now())) {
                throw new IllegalArgumentException("Return date cannot be in the past");
            }
        });

        assertThrows(IllegalArgumentException.class, () -> {
            if (rentalDTO.getLastUpdate().isAfter(LocalDateTime.now())) {
                throw new IllegalArgumentException("Last update cannot be in the future");
            }
        });
    }
}
