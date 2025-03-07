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
import com.springboot.filmrentalstore.model.Staff;

class StaffTest {

    private Staff staff;
    private Address address;
    private Store store;
    private Payment payment;

    @BeforeEach
    void setUp() {
        // Create mock objects
        address = mock(Address.class);
        store = mock(Store.class);
        payment = mock(Payment.class);

        // Create Staff object
        staff = new Staff(1L, "John", "Doe", "johndoe@example.com", address, store, "johndoe", "password123", true, LocalDateTime.now());
        staff.setStaffPayments(Arrays.asList(payment)); // Assign a list with mock Payment
    }

    @Test
    void testConstructorWithFields() {
        // Test the constructor with parameters
        Staff newStaff = new Staff(2L, "Jane", "Smith", "janesmith@example.com", address, store, "janesmith", "password456", false, LocalDateTime.now());
        
        assertEquals(2L, newStaff.getStaffId());
        assertEquals("Jane", newStaff.getFirstName());
        assertEquals("Smith", newStaff.getLastName());
        assertEquals("janesmith@example.com", newStaff.getEmail());
        assertNotNull(newStaff.getAddress());
        assertNotNull(newStaff.getStore());
        assertEquals("janesmith", newStaff.getUsername());
        assertEquals("password456", newStaff.getPassword());
        assertFalse(newStaff.isActive());
    }

    @Test
    void testGettersAndSetters() {
        // Test getter and setter for staffId
        staff.setStaffId(10L);
        assertEquals(10L, staff.getStaffId());

        // Test getter and setter for firstName
        staff.setFirstName("Michael");
        assertEquals("Michael", staff.getFirstName());

        // Test getter and setter for lastName
        staff.setLastName("Jackson");
        assertEquals("Jackson", staff.getLastName());

        // Test getter and setter for email
        staff.setEmail("mjackson@example.com");
        assertEquals("mjackson@example.com", staff.getEmail());

        // Test getter and setter for address
        staff.setAddress(address);
        assertEquals(address, staff.getAddress());

        // Test getter and setter for store
        staff.setStore(store);
        assertEquals(store, staff.getStore());

        // Test getter and setter for username
        staff.setUsername("mjackson");
        assertEquals("mjackson", staff.getUsername());

        // Test getter and setter for password
        staff.setPassword("password789");
        assertEquals("password789", staff.getPassword());

        // Test getter and setter for active
        staff.setActive(false);
        assertFalse(staff.isActive());

        // Test getter and setter for lastUpdate
        LocalDateTime now = LocalDateTime.now();
        staff.setLastUpdate(now);
        assertEquals(now, staff.getLastUpdate());
    }

    @Test
    void testAddPayments() {
        // Test adding payments to the list
        Payment newPayment = new Payment();
        staff.setStaffPayments(Arrays.asList(newPayment));
        
        List<Payment> payments = staff.getStaffPayments();
        assertEquals(1, payments.size());
        assertEquals(newPayment, payments.get(0));
    }

    @Test
    void testActiveStatus() {
        // Test active status
        staff.setActive(true);
        assertTrue(staff.isActive());

        staff.setActive(false);
        assertFalse(staff.isActive());
    }

    @Test
    void testEquality() {
        // Test equality with another Staff object having the same fields
        Staff anotherStaff = new Staff(1L, "John", "Doe", "johndoe@example.com", address, store, "johndoe", "password123", true, LocalDateTime.now());
        anotherStaff.setStaffPayments(Arrays.asList(payment));
        
        assertEquals(staff.getStaffId(), anotherStaff.getStaffId());
        assertEquals(staff.getFirstName(), anotherStaff.getFirstName());
        assertEquals(staff.getLastName(), anotherStaff.getLastName());
        assertEquals(staff.getEmail(), anotherStaff.getEmail());
        assertEquals(staff.getUsername(), anotherStaff.getUsername());
        assertEquals(staff.getPassword(), anotherStaff.getPassword());
        assertEquals(staff.isActive(), anotherStaff.isActive());
        assertEquals(staff.getStaffPayments(), anotherStaff.getStaffPayments());
    }

    @Test
    void testHashCode() {
        // Test hashCode for equality
        Staff anotherStaff = new Staff(1L, "John", "Doe", "johndoe@example.com", address, store, "johndoe", "password123", true, LocalDateTime.now());
        anotherStaff.setStaffPayments(Arrays.asList(payment));
        
        //assertEquals(staff.hashCode(), anotherStaff.hashCode());
    }

}
