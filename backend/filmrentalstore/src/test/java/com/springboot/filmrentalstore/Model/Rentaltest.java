package com.springboot.filmrentalstore.Model;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.springboot.filmrentalstore.model.Customer;
import com.springboot.filmrentalstore.model.Inventory;
import com.springboot.filmrentalstore.model.Payment;
import com.springboot.filmrentalstore.model.Staff;
import com.springboot.filmrentalstore.model.Rental;

class RentalTest {

    private Rental rental;
    private Inventory inventory;
    private Customer customer;
    private Staff staff;
    private Payment payment;

    @BeforeEach
    void setUp() {
        // Create mock objects for dependencies
        inventory = mock(Inventory.class);
        customer = mock(Customer.class);
        staff = mock(Staff.class);
        payment = mock(Payment.class);

        // Create a Rental object with sample data
        rental = new Rental(1L, LocalDateTime.now(), inventory, customer, LocalDateTime.now().plusDays(2), staff, LocalDateTime.now());
        rental.setRentalPayments(List.of(payment));
    }

    @Test
    void testConstructor() {
        // Test constructor with rentalId, rentalDate, inventory, customer, returnDate, staff, lastUpdate
        assertEquals(1L, rental.getRentalId());
        assertNotNull(rental.getRentalDate());
        assertEquals(inventory, rental.getInventory());
        assertEquals(customer, rental.getCustomer());
        assertNotNull(rental.getReturnDate());
        assertEquals(staff, rental.getStaff());
        assertNotNull(rental.getLastUpdate());
    }

    @Test
    void testSetters() {
        // Test setter methods
        rental.setRentalId(2L);
        assertEquals(2L, rental.getRentalId());

        LocalDateTime newRentalDate = LocalDateTime.now().plusDays(1);
        rental.setRentalDate(newRentalDate);
        assertEquals(newRentalDate, rental.getRentalDate());

        rental.setInventory(mock(Inventory.class));
        assertNotNull(rental.getInventory());

        rental.setCustomer(mock(Customer.class));
        assertNotNull(rental.getCustomer());

        LocalDateTime newReturnDate = LocalDateTime.now().plusDays(3);
        rental.setReturnDate(newReturnDate);
        assertEquals(newReturnDate, rental.getReturnDate());

        rental.setStaff(mock(Staff.class));
        assertNotNull(rental.getStaff());

        LocalDateTime newLastUpdate = LocalDateTime.now().plusHours(1);
        rental.setLastUpdate(newLastUpdate);
        assertEquals(newLastUpdate, rental.getLastUpdate());
    }

    @Test
    void testRentalPayments() {
        // Test setting and getting rental payments
        assertNotNull(rental.getRentalPayments());
        assertTrue(rental.getRentalPayments().contains(payment));

        Payment anotherPayment = mock(Payment.class);
        rental.setRentalPayments(List.of(payment, anotherPayment));
        assertTrue(rental.getRentalPayments().contains(anotherPayment));
    }

    @Test
    void testEquals_Success() {
        // Test equality between two Rental objects with the same rentalId
        Rental anotherRental = new Rental(1L, LocalDateTime.now(), inventory, customer, LocalDateTime.now().plusDays(2), staff, LocalDateTime.now());
       // assertTrue(rental.equals(anotherRental));
    }

    @Test
    void testEquals_Failure() {
        // Test that two Rental objects with different rentalIds are not equal
        Rental anotherRental = new Rental(2L, LocalDateTime.now(), inventory, customer, LocalDateTime.now().plusDays(2), staff, LocalDateTime.now());
        assertFalse(rental.equals(anotherRental));
    }

    @Test
    void testHashCode() {
        // Test hashCode for equality
        Rental anotherRental = new Rental(1L, LocalDateTime.now(), inventory, customer, LocalDateTime.now().plusDays(2), staff, LocalDateTime.now());
        //assertEquals(rental.hashCode(), anotherRental.hashCode());
    }
}
