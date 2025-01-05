package com.springboot.filmrentalstore.Repo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import com.springboot.filmrentalstore.model.City;
import com.springboot.filmrentalstore.repo.CityRepo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

class CityRepoTest {

    @Mock
    private CityRepo cityRepo;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindById() {
        // Arrange
        Long cityId = 1L;
        City city = new City();
        city.setCityId(cityId);
        city.setCityName("New York");

        when(cityRepo.findById(cityId)).thenReturn(Optional.of(city));

        // Act
        Optional<City> result = cityRepo.findById(cityId);

        // Assert
        assertEquals(cityId, result.get().getCityId());
        assertEquals("New York", result.get().getCityName());
        verify(cityRepo, times(1)).findById(cityId);
    }
}
