package com.springboot.filmrentalstore.DTO;

import com.springboot.filmrentalstore.model.Address;
import com.springboot.filmrentalstore.model.Store;
import com.springboot.filmrentalstore.DTO.ManagerDetailsDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class ManagerDetailsDTOTest {

    private ManagerDetailsDTO managerDetailsDTO;
    private Address mockAddress;
    private Store mockStore;

    @BeforeEach
    void setUp() {
        // Create mock objects for Address and Store
        mockAddress = Mockito.mock(Address.class);
        mockStore = Mockito.mock(Store.class);

        // Create an instance of ManagerDetailsDTO
        managerDetailsDTO = new ManagerDetailsDTO();
    }

    @Test
    void testSetAndGetStaffId() {
        managerDetailsDTO.setStaffId(1L);
        assertEquals(1L, managerDetailsDTO.getStaffId());
    }

    @Test
    void testSetAndGetFirstName() {
        managerDetailsDTO.setFirstName("John");
        assertEquals("John", managerDetailsDTO.getFirstName());
    }

    @Test
    void testSetAndGetLastName() {
        managerDetailsDTO.setLastName("Doe");
        assertEquals("Doe", managerDetailsDTO.getLastName());
    }

    @Test
    void testSetAndGetEmail() {
        managerDetailsDTO.setEmail("john.doe@example.com");
        assertEquals("john.doe@example.com", managerDetailsDTO.getEmail());
    }

    @Test
    void testSetAndGetAddress() {
        managerDetailsDTO.setAddress(mockAddress);
        assertEquals(mockAddress, managerDetailsDTO.getAddress());
    }

    @Test
    void testSetAndGetStore() {
        managerDetailsDTO.setStore(mockStore);
        assertEquals(mockStore, managerDetailsDTO.getStore());
    }

    @Test
    void testDefaultConstructor() {
        ManagerDetailsDTO newDTO = new ManagerDetailsDTO();
        assertNotNull(newDTO);
    }
}
