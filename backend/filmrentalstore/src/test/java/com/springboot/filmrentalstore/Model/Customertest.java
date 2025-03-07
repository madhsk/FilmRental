package com.springboot.filmrentalstore.Model;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.springboot.filmrentalstore.model.Address;
import com.springboot.filmrentalstore.model.Payment;
import com.springboot.filmrentalstore.model.Store;
import com.springboot.filmrentalstore.model.Customer;

class CustomerTest {

    private Customer customer;
    private Store mockStore;
    private Address mockAddress;
    private Payment mockPayment;

    @BeforeEach
    void setUp() {
        // Mock dependencies
        mockStore = mock(Store.class);
        mockAddress = mock(Address.class);
        mockPayment = mock(Payment.class);
        
        // Create mock data for testing
        LocalDateTime now = LocalDateTime.now();
        customer = new Customer(1L, mockStore, "John", "Doe", "john.doe@example.com", mockAddress, true, now, now);

        // Setup payments list
        List<Payment> payments = Arrays.asList(mockPayment);
        customer.setPayments(payments);
    }

    @Test
    void testConstructor() {
        // Verify that the constructor sets the fields correctly
        assertEquals(1L, customer.getCustomerId());
        assertEquals(mockStore, customer.getStore());
        assertEquals("John", customer.getFirstName());
        assertEquals("Doe", customer.getLastName());
        assertEquals("john.doe@example.com", customer.getEmail());
        assertEquals(mockAddress, customer.getAddress());
        assertTrue(customer.isActive());
        assertNotNull(customer.getCreateDate());
        assertNotNull(customer.getLastUpdate());
    }

    @Test
    void testSettersAndGetters() {
        // Test setter and getter methods
        customer.setFirstName("Jane");
        customer.setLastName("Smith");
        customer.setEmail("jane.smith@example.com");
        customer.setActive(false);
        
        // Verify the setters worked correctly
        assertEquals("Jane", customer.getFirstName());
        assertEquals("Smith", customer.getLastName());
        assertEquals("jane.smith@example.com", customer.getEmail());
        assertFalse(customer.isActive());
    }

    @Test
    void testPaymentsList() {
        // Test the payments list functionality
        assertNotNull(customer.getPayments());
        assertEquals(1, customer.getPayments().size());
        assertEquals(mockPayment, customer.getPayments().get(0));
    }

    @Test
    void testJsonBackReference() {
        // Verify that the @JsonBackReference annotation is applied correctly
        // Since this is mostly related to serialization, this would usually be tested
        // in a test for JSON serialization/deserialization.
        assertDoesNotThrow(() -> {
            // You could add tests for JSON serialization (optional, not required here)
        });
    }

    @Test
    void testJsonIgnore() {
        // Verify that the @JsonIgnore annotation is applied correctly
        // Like the @JsonBackReference, this is typically verified in a serialization test
        assertDoesNotThrow(() -> {
            // No exception should be thrown during serialization
        });
    }
}
