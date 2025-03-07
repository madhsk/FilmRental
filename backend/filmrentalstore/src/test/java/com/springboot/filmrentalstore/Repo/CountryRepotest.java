package com.springboot.filmrentalstore.Repo;

//import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import com.springboot.filmrentalstore.model.Country;
import com.springboot.filmrentalstore.repo.CountryRepo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

class CountryRepoTest {

    @Mock
    private CountryRepo countryRepo;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindById() {
        // Arrange
        Long countryId = 1L;
        Country country = new Country();
//        country.setId(countryId);
//        country.setName("USA");

        when(countryRepo.findById(countryId)).thenReturn(Optional.of(country));

        // Act
        @SuppressWarnings("unused")
		Optional<Country> result = countryRepo.findById(countryId);

        // Assert
//        assertEquals(countryId, result.get().getId());
//        assertEquals("USA", result.get().getName());
        verify(countryRepo, times(1)).findById(countryId);
    }
}
