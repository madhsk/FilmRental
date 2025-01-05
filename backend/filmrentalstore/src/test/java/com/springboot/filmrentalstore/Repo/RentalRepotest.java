package com.springboot.filmrentalstore.Repo;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.springboot.filmrentalstore.model.Rental;
import com.springboot.filmrentalstore.repo.RentalRepo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

class RentalRepoTest {

    @Mock
    private RentalRepo rentalRepo;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSaveRental() {
        // Arrange
        Rental rental = new Rental();
        //rental.setId(1L);
        //rental.setRentalDate("2025-01-02");

        when(rentalRepo.save(rental)).thenReturn(rental);

        // Act
        Rental savedRental = rentalRepo.save(rental);

        // Assert
        assertNotNull(savedRental);
        //assertEquals(1L, savedRental.getId());
//        assertEquals("2025-01-02", savedRental.getRentalDate());
        verify(rentalRepo, times(1)).save(rental);
    }

    @Test
    void testFindById() {
        // Arrange
        Long rentalId = 1L;
        Rental rental = new Rental();
//        rental.setId(rentalId);
//        rental.setRentalDate("2025-01-02");

        when(rentalRepo.findById(rentalId)).thenReturn(Optional.of(rental));

        // Act
        Optional<Rental> foundRental = rentalRepo.findById(rentalId);

        // Assert
        assertTrue(foundRental.isPresent());
        //assertEquals(rentalId, foundRental.get().getId());
        //assertEquals("2025-01-02", foundRental.get().getRentalDate());
        verify(rentalRepo, times(1)).findById(rentalId);
    }

    @Test
    void testFindById_WhenRentalNotFound() {
        // Arrange
        Long rentalId = 999L;

        when(rentalRepo.findById(rentalId)).thenReturn(Optional.empty());

        // Act
        Optional<Rental> foundRental = rentalRepo.findById(rentalId);

        // Assert
        assertFalse(foundRental.isPresent());
        verify(rentalRepo, times(1)).findById(rentalId);
    }

    @Test
    void testDeleteRental() {
        // Arrange
        Rental rental = new Rental();
//        rental.setId(1L);
//        rental.setRentalDate("2025-01-02");

        // Act
        rentalRepo.delete(rental);

        // Assert
        verify(rentalRepo, times(1)).delete(rental);
    }
}
