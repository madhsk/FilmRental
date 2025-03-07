package com.springboot.filmrentalstore.Repo;

import com.springboot.filmrentalstore.model.Address;
import com.springboot.filmrentalstore.repo.AddressRepo;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class AddressRepoTest {

    @Mock
    private AddressRepo addressRepo;

    @Test
    void testFindByPhone() {
        // Initialize mocks
        MockitoAnnotations.openMocks(this);

        // Test data
        String phone = "123-456-7890";
        Address address = new Address();
        address.setAddressId(1L);
        address.setPhone(phone);
//        address.setStreet("123 Main St");
//        address.setCity("Springfield");

        // Mock behavior
        when(addressRepo.findByPhone(phone)).thenReturn(address);

        // Test the method
        Address result = addressRepo.findByPhone(phone);

        // Verify results
        assertEquals(phone, result.getPhone());
//        assertEquals("123 Main St", result.getStreet());
//        assertEquals("Springfield", result.getCity());
    }
}
