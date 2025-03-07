package com.springboot.filmrentalstore.controller;

import com.springboot.filmrentalstore.DTO.*;
import com.springboot.filmrentalstore.exception.InvalidInputException;
import com.springboot.filmrentalstore.exception.ResourceNotFoundException;
import com.springboot.filmrentalstore.model.Customer;
import com.springboot.filmrentalstore.model.Staff;
import com.springboot.filmrentalstore.model.Store;
import com.springboot.filmrentalstore.service.StoreService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class StoreControllerTest {

    @InjectMocks
    private StoreController storeController;

    @Mock
    private StoreService storeService;

    @Test
    public void testGetAllStores() {
        // Arrange
        List<Store> stores = Arrays.asList(new Store(), new Store());
        when(storeService.getAllStores()).thenReturn(stores);

        // Act
        List<Store> result = storeController.getAllStores();

        // Assert
        assertNotNull(result);
        assertEquals(2, result.size());
        verify(storeService, times(1)).getAllStores();
    }

    @Test
    public void testAddStore() throws ResourceNotFoundException {
        // Arrange
        StoreDTO storeDTO = new StoreDTO();
        
        Store newStore = new Store();
        when(storeService.addStore(storeDTO)).thenReturn(newStore);

        // Act
        ResponseEntity<?> response = storeController.addStore(storeDTO);

        // Assert
        assertNotNull(response);
        assertEquals(201, response.getStatusCodeValue());
        assertEquals("Store Created", response.getBody());
        verify(storeService, times(1)).addStore(storeDTO);
    }

    @Test
    public void testAssignAddressToStore() throws ResourceNotFoundException {
        // Arrange
        Long storeId = 1L;
        Long addressId = 2L;
        StoreDTO storeDTO = new StoreDTO();
        when(storeService.assignAddressToStore(storeId, addressId)).thenReturn(storeDTO);

        // Act
        ResponseEntity<StoreDTO> response = storeController.assignAddressToStore(storeId, addressId);

        // Assert
        assertNotNull(response);
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(storeDTO, response.getBody());
        verify(storeService, times(1)).assignAddressToStore(storeId, addressId);
    }

    @Test
    public void testGetStoresByCity() throws ResourceNotFoundException {
        // Arrange
        String city = "New York";
        List<StoreDTO> stores = Arrays.asList(new StoreDTO(), new StoreDTO());
        when(storeService.getStoresByCity(city)).thenReturn(stores);

        // Act
        List<StoreDTO> result = storeController.getStoresByCity(city);

        // Assert
        assertNotNull(result);
        assertEquals(2, result.size());
        verify(storeService, times(1)).getStoresByCity(city);
    }

    @Test
    public void testGetStoreByPhone() throws ResourceNotFoundException {
        // Arrange
        String phone = "1234567890";
        StoreDTO storeDTO = new StoreDTO();
        when(storeService.getStoreByPhone(phone)).thenReturn(storeDTO);

        // Act
        ResponseEntity<StoreDTO> response = storeController.getStoreByPhone(phone);

        // Assert
        assertNotNull(response);
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(storeDTO, response.getBody());
        verify(storeService, times(1)).getStoreByPhone(phone);
    }

    @Test
    public void testUpdateStorePhoneNumber() throws ResourceNotFoundException {
        // Arrange
        Long storeId = 1L;
        String phone = "1234567890";
        String message = "Phone number updated successfully.";
        when(storeService.updatePhoneNumber(storeId, phone)).thenReturn(message);

        // Act
        ResponseEntity<?> response;
		try {
			response = storeController.updateStorePhoneNumber(storeId, phone);
			assertNotNull(response);
			assertEquals(200, response.getStatusCodeValue());
			assertEquals(message, response.getBody());
		} catch (InvalidInputException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        // Assert
        verify(storeService, times(1)).updatePhoneNumber(storeId, phone);
    }

    @Test
    public void testGetStaffByStoreId() throws ResourceNotFoundException {
        // Arrange
        Long storeId = 1L;
        List<Staff> staffList = Arrays.asList(new Staff(), new Staff());
        when(storeService.getStaffByStoreId(storeId)).thenReturn(staffList);

        // Act
        List<Staff> result = storeController.getStaffByStoreId(storeId);

        // Assert
        assertNotNull(result);
        assertEquals(2, result.size());
        verify(storeService, times(1)).getStaffByStoreId(storeId);
    }

    @Test
    public void testGetManagerDetailsByStoreId() throws ResourceNotFoundException {
        // Arrange
        Long storeId = 1L;
        ManagerDetailsDTO managerDetails = new ManagerDetailsDTO();
        when(storeService.getManagerDetailsByStoreId(storeId)).thenReturn(managerDetails);

        // Act
        ResponseEntity<ManagerDetailsDTO> response = storeController.getManagerDetailsByStoreId(storeId);

        // Assert
        assertNotNull(response);
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(managerDetails, response.getBody());
        verify(storeService, times(1)).getManagerDetailsByStoreId(storeId);
    }
}
