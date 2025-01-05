package com.springboot.filmrentalstore.Model;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.springboot.filmrentalstore.model.City;
import com.springboot.filmrentalstore.model.Country;

class Citytest {

    @Test
    void testDefaultConstructor() {
        // Act
        City city = new City();

        // Assert
        assertNotNull(city);
        assertNull(city.getCityId());
        assertNull(city.getCityName());
        assertNull(city.getCountry());
        assertNull(city.getLastUpdate());
    }

    @Test
    void testParameterizedConstructor() {
        // Arrange
        Long cityId = 1L;
        String cityName = "New York";
        Country country = Mockito.mock(Country.class);
        LocalDateTime lastUpdate = LocalDateTime.now();

        // Act
        City city = new City(cityId, cityName, country, lastUpdate);

        // Assert
        assertEquals(cityId, city.getCityId());
        assertEquals(cityName, city.getCityName());
        assertEquals(country, city.getCountry());
        assertEquals(lastUpdate, city.getLastUpdate());
    }

    @Test
    void testSetCityId() {
        // Arrange
        City city = new City();
        Long cityId = 2L;

        // Act
        city.setCityId(cityId);

        // Assert
        assertEquals(cityId, city.getCityId());
    }

    @Test
    void testSetCityName() {
        // Arrange
        City city = new City();
        String cityName = "Los Angeles";

        // Act
        city.setCityName(cityName);

        // Assert
        assertEquals(cityName, city.getCityName());
    }

    @Test
    void testSetCountry() {
        // Arrange
        City city = new City();
        Country country = Mockito.mock(Country.class);

        // Act
        city.setCountry(country);

        // Assert
        assertEquals(country, city.getCountry());
    }

    @Test
    void testSetLastUpdate() {
        // Arrange
        City city = new City();
        LocalDateTime lastUpdate = LocalDateTime.now();

        // Act
        city.setLastUpdate(lastUpdate);

        // Assert
        assertEquals(lastUpdate, city.getLastUpdate());
    }
}
