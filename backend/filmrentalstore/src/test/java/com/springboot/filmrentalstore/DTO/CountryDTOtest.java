package com.springboot.filmrentalstore.DTO;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

class CountryDTOTest {

    @Test
    void testGetterAndSetter() {
        // Arrange
        CountryDTO countryDTO = new CountryDTO();
        Long expectedCountryId = 1L;
        String expectedCountry = "USA";
        LocalDateTime expectedLastUpdate = LocalDateTime.now();
        List<Long> expectedCityIds = Arrays.asList(101L, 102L, 103L);

        // Act
        countryDTO.setCountryId(expectedCountryId);
        countryDTO.setCountry(expectedCountry);
        countryDTO.setLastUpdate(expectedLastUpdate);
        countryDTO.setCityIds(expectedCityIds);

        // Assert
        assertEquals(expectedCountryId, countryDTO.getCountryId());
        assertEquals(expectedCountry, countryDTO.getCountry());
        assertEquals(expectedLastUpdate, countryDTO.getLastUpdate());
        assertEquals(expectedCityIds, countryDTO.getCityIds());
    }

    @Test
    void testDefaultConstructor() {
        // Act
        CountryDTO countryDTO = new CountryDTO();

        // Assert
        assertNull(countryDTO.getCountryId());
        assertNull(countryDTO.getCountry());
        assertNull(countryDTO.getLastUpdate());
        assertNull(countryDTO.getCityIds());
    }
}
