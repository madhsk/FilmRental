package com.springboot.filmrentalstore.DTO;

import com.springboot.filmrentalstore.model.City;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AddressDTOTest {

    @Test
    void testAddressDTO_NoArgsConstructor() {
        AddressDTO addressDTO = new AddressDTO();

        assertNull(addressDTO.getAddressId());
        assertNull(addressDTO.getAddress());
        assertNull(addressDTO.getAddress2());
        assertNull(addressDTO.getDistrict());
        assertNull(addressDTO.getCity());
        assertNull(addressDTO.getPostalCode());
        assertNull(addressDTO.getPhone());
    }

    @Test
    void testAddressDTO_SettersAndGetters() {
        AddressDTO addressDTO = new AddressDTO();

        Long addressId = 1L;
        String address = "123 Main St";
        String address2 = "Apt 4B";
        String district = "Downtown";
        City city = new City();
        String postalCode = "12345";
        String phone = "123-456-7890";

        addressDTO.setAddressId(addressId);
        addressDTO.setAddress(address);
        addressDTO.setAddress2(address2);
        addressDTO.setDistrict(district);
        addressDTO.setCity(city);
        addressDTO.setPostalCode(postalCode);
        addressDTO.setPhone(phone);

        assertEquals(addressId, addressDTO.getAddressId());
        assertEquals(address, addressDTO.getAddress());
        assertEquals(address2, addressDTO.getAddress2());
        assertEquals(district, addressDTO.getDistrict());
        assertEquals(city, addressDTO.getCity());
        assertEquals(postalCode, addressDTO.getPostalCode());
        assertEquals(phone, addressDTO.getPhone());
    }
}
