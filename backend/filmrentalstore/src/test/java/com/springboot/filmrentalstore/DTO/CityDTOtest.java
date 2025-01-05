package com.springboot.filmrentalstore.DTO;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CityDTOTest {

    @Test
    void testCityDTO_NoArgsConstructor() {
        CityDTO cityDTO = new CityDTO();

        assertNull(cityDTO.getCityId());
        assertNull(cityDTO.getCityName());
        assertNull(cityDTO.getCountry());
    }

    @Test
    void testCityDTO_SettersAndGetters() {
        CityDTO cityDTO = new CityDTO();

        Long cityId = 1L;
        String cityName = "New York";
        CityDTO countryDTO = new CityDTO();
        countryDTO.setCityId(2L);
        countryDTO.setCityName("USA");

        cityDTO.setCityId(cityId);
        cityDTO.setCityName(cityName);
        cityDTO.setCountry(countryDTO);

        assertEquals(cityId, cityDTO.getCityId());
        assertEquals(cityName, cityDTO.getCityName());
        assertEquals(countryDTO, cityDTO.getCountry());
    }

    @Test
    void testCityDTO_CountryField() {
        CityDTO countryDTO = new CityDTO();
        countryDTO.setCityId(2L);
        countryDTO.setCityName("USA");

        assertEquals(2L, countryDTO.getCityId());
        assertEquals("USA", countryDTO.getCityName());
        assertNull(countryDTO.getCountry()); // Nested country should be null
    }
}
