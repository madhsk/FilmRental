package com.springboot.filmrentalstore.Model;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.springboot.filmrentalstore.model.Address;
import com.springboot.filmrentalstore.model.City;
import com.springboot.filmrentalstore.model.Store;

class Addresstest {

    @Test
    void testConstructorAndGetters() {
        // Arrange
        Long addressId = 1L;
        String address = "123 Main St";
        String district = "District 1";
        City city = Mockito.mock(City.class);
        String postalCode = "12345";
        String phone = "123-456-7890";
        LocalDateTime lastUpdate = LocalDateTime.now();

        // Act
        Address addressObj = new Address(addressId, address, district, city, postalCode, phone, lastUpdate);

        // Assert
        assertEquals(addressId, addressObj.getAddressId());
        assertEquals(address, addressObj.getAddress());
        assertEquals(district, addressObj.getDistrict());
        assertEquals(city, addressObj.getCity());
        assertEquals(postalCode, addressObj.getPostalCode());
        assertEquals(phone, addressObj.getPhone());
        assertEquals(lastUpdate, addressObj.getLastUpdate());
    }

    @Test
    void testSetAddressId() {
        // Arrange
        Address address = new Address();
        Long addressId = 2L;

        // Act
        address.setAddressId(addressId);

        // Assert
        assertEquals(addressId, address.getAddressId());
    }

    @Test
    void testSetAddress() {
        // Arrange
        Address address = new Address();
        String addressLine = "456 Elm St";

        // Act
        address.setAddress(addressLine);

        // Assert
        assertEquals(addressLine, address.getAddress());
    }

    @Test
    void testSetDistrict() {
        // Arrange
        Address address = new Address();
        String district = "District 2";

        // Act
        address.setDistrict(district);

        // Assert
        assertEquals(district, address.getDistrict());
    }

    @Test
    void testSetCity() {
        // Arrange
        Address address = new Address();
        City city = Mockito.mock(City.class);

        // Act
        address.setCity(city);

        // Assert
        assertEquals(city, address.getCity());
    }

    @Test
    void testSetPostalCode() {
        // Arrange
        Address address = new Address();
        String postalCode = "54321";

        // Act
        address.setPostalCode(postalCode);

        // Assert
        assertEquals(postalCode, address.getPostalCode());
    }

    @Test
    void testSetPhone() {
        // Arrange
        Address address = new Address();
        String phone = "987-654-3210";

        // Act
        address.setPhone(phone);

        // Assert
        assertEquals(phone, address.getPhone());
    }

    @Test
    void testSetLastUpdate() {
        // Arrange
        Address address = new Address();
        LocalDateTime beforeUpdate = LocalDateTime.now();

        // Act
        address.setLastUpdate(beforeUpdate);

        // Assert
        assertEquals(beforeUpdate, address.getLastUpdate());
    }

    @Test
    void testSetStores() {
        // Arrange
        Address address = new Address();
        List<Store> stores = Mockito.mock(List.class);

        // Act
        address.setStores(stores);

        // Assert
        assertEquals(stores, address.getStores());
    }
}
