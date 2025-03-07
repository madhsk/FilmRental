package com.springboot.filmrentalstore.Model;


import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.springboot.filmrentalstore.model.City;
import com.springboot.filmrentalstore.model.Country;

class Countrytest {

    @Test
    void testDefaultConstructor() {
        // Act
        Country country = new Country();

        // Assert
        assertNotNull(country);
        assertNull(country.getCountryId());
        assertNull(country.getCountry());
        assertNull(country.getLastUpdate());
        assertNull(country.getCities());
    }

    @Test
    void testParameterizedConstructor() {
        // Arrange
        Long countryId = 1L;
        String countryName = "United States";
        LocalDateTime lastUpdate = LocalDateTime.now();

        // Act
        Country country = new Country(countryId, countryName, lastUpdate);

        // Assert
        assertEquals(countryId, country.getCountryId());
        assertEquals(countryName, country.getCountry());
        assertEquals(lastUpdate, country.getLastUpdate());
    }

    @Test
    void testSetCountryId() {
        // Arrange
        Country country = new Country();
        Long countryId = 2L;

        // Act
        country.setCountryId(countryId);

        // Assert
        assertEquals(countryId, country.getCountryId());
    }

    @Test
    void testSetCountryName() {
        // Arrange
        Country country = new Country();
        String countryName = "Canada";

        // Act
        country.setCountry(countryName);

        // Assert
        assertEquals(countryName, country.getCountry());
    }

    @Test
    void testSetLastUpdate() {
        // Arrange
        Country country = new Country();
        LocalDateTime lastUpdate = LocalDateTime.now();

        // Act
        country.setLastUpdate(lastUpdate);

        // Assert
        assertEquals(lastUpdate, country.getLastUpdate());
    }

    @Test
    void testSetCities() {
        // Arrange
        Country country = new Country();
        List<City> cities = Mockito.mock(List.class);

        // Act
        country.setCities(cities);

        // Assert
        assertEquals(cities, country.getCities());
    }
}
