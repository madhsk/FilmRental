package com.springboot.filmrentalstore.DTO;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.springboot.filmrentalstore.model.Address;
import com.springboot.filmrentalstore.model.Customer;
import com.springboot.filmrentalstore.model.Staff;
import com.springboot.filmrentalstore.model.Store;

class StoreDTOTest {

    @Test
    void testConstructorAndGetterMethods() {
        // Arrange
        Long expectedStoreId = 1L;
        Address expectedAddress = new Address();
        Store expectedStore = new Store();
        LocalDateTime expectedLastUpdate = LocalDateTime.now();
        List<Customer> expectedCustomers = new ArrayList<>();
        List<Staff> expectedStaffList = new ArrayList<>();

        // Act
        StoreDTO storeDTO = new StoreDTO(
            expectedStoreId,
            expectedAddress,
           
            expectedLastUpdate,
            expectedCustomers,
            expectedStaffList
        );

        // Assert
        assertEquals(expectedStoreId, storeDTO.getStoreId());
        assertEquals(expectedAddress, storeDTO.getAddress());
        
        assertEquals(expectedLastUpdate, storeDTO.getLastUpdate());
        assertEquals(expectedCustomers, storeDTO.getCustomers());
        assertEquals(expectedStaffList, storeDTO.getStaff_list());
    }

    @Test
    void testSetterMethods() {
        // Arrange
        StoreDTO storeDTO = new StoreDTO();
        Long expectedStoreId = 2L;
        Address expectedAddress = new Address();
        Store expectedStore = new Store();
        LocalDateTime expectedLastUpdate = LocalDateTime.now();
        List<Customer> expectedCustomers = new ArrayList<>();
        List<Staff> expectedStaffList = new ArrayList<>();

        // Act
        storeDTO.setStoreId(expectedStoreId);
        storeDTO.setAddress(expectedAddress);
        
        storeDTO.setLastUpdate(expectedLastUpdate);
        storeDTO.setCustomers(expectedCustomers);
        storeDTO.setStaff_list(expectedStaffList);

        // Assert
        assertEquals(expectedStoreId, storeDTO.getStoreId());
        assertEquals(expectedAddress, storeDTO.getAddress());
        //assertEquals(expectedStore, storeDTO.getStoreId());
        assertEquals(expectedLastUpdate, storeDTO.getLastUpdate());
        assertEquals(expectedCustomers, storeDTO.getCustomers());
        assertEquals(expectedStaffList, storeDTO.getStaff_list());
    }

    @Test
    void testDefaultConstructor() {
        // Act
        StoreDTO storeDTO = new StoreDTO();

        // Assert
        assertNull(storeDTO.getStoreId());
        assertNull(storeDTO.getAddress());
        assertNull(storeDTO.getStoreId());
        assertNull(storeDTO.getLastUpdate());
        assertNull(storeDTO.getCustomers());
        assertNull(storeDTO.getStaff_list());
    }
}
