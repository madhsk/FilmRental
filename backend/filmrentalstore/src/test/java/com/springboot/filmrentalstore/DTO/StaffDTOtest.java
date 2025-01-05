package com.springboot.filmrentalstore.DTO;

import com.springboot.filmrentalstore.model.Address;
import com.springboot.filmrentalstore.model.Store;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StaffDTOTest {

    private StaffDTO staffDTO;

    @BeforeEach
    void setUp() {
        // Initialize StaffDTO object before each test
        staffDTO = new StaffDTO();
    }

    @Test
    void testSetAndGetStaffId() {
        // Test setting and getting staffId
        staffDTO.setStaffId(1L);
        assertEquals(1L, staffDTO.getStaffId());
    }

    @Test
    void testSetAndGetFirstName() {
        // Test setting and getting firstName
        staffDTO.setFirstName("John");
        assertEquals("John", staffDTO.getFirstName());
    }

    @Test
    void testSetAndGetLastName() {
        // Test setting and getting lastName
        staffDTO.setLastName("Doe");
        assertEquals("Doe", staffDTO.getLastName());
    }

    @Test
    void testSetAndGetEmail() {
        // Test setting and getting email
        staffDTO.setEmail("john.doe@example.com");
        assertEquals("john.doe@example.com", staffDTO.getEmail());
    }

    @Test
    void testSetAndGetStore() {
        // Test setting and getting store
        Store store = new Store();
        staffDTO.setStore(store);
        assertEquals(store, staffDTO.getStore());
    }

    @Test
    void testSetAndGetAddress() {
        // Test setting and getting address
        Address address = new Address();
        staffDTO.setAddress(address);
        assertEquals(address, staffDTO.getAddress());
    }

    @Test
    void testDefaultConstructor() {
        // Verify that the default constructor works and creates a valid object
        StaffDTO newDTO = new StaffDTO();
        assertNotNull(newDTO);
    }
}
