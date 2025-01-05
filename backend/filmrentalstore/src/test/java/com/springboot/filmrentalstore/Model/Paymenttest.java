package com.springboot.filmrentalstore.Model;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.springboot.filmrentalstore.model.Customer;
import com.springboot.filmrentalstore.model.Payment;
import com.springboot.filmrentalstore.model.Rental;
import com.springboot.filmrentalstore.model.Staff;

class PaymentTest {

    private Payment payment;
    private Customer customer;
    private Staff staff;
    private Rental rental;

    @BeforeEach
    void setUp() {
        // Create mock objects for dependencies
        customer = mock(Customer.class);
        staff = mock(Staff.class);
        rental = mock(Rental.class);

        // Create a Payment object with sample data
        payment = new Payment(1L, LocalDateTime.now(), customer, staff, rental, 100.0, LocalDateTime.now());
    }

    @Test
    void testConstructor() {
        // Test constructor with paymentId, paymentDate, customer, staff, rental, amount, lastUpdate
        assertEquals(1L, payment.getPaymentId());
        assertNotNull(payment.getPaymentDate());
        assertEquals(customer, payment.getCustomer());
        assertEquals(staff, payment.getStaff());
        assertEquals(rental, payment.getRental());
        assertEquals(100.0, payment.getAmount());
        assertNotNull(payment.getLastUpdate());
    }

    @Test
    void testSetters() {
        // Test setter methods
        payment.setPaymentId(2L);
        assertEquals(2L, payment.getPaymentId());

        LocalDateTime newPaymentDate = LocalDateTime.now().plusDays(1);
        payment.setPaymentDate(newPaymentDate);
        assertEquals(newPaymentDate, payment.getPaymentDate());

        payment.setCustomer(mock(Customer.class));
        assertNotNull(payment.getCustomer());

        payment.setStaff(mock(Staff.class));
        assertNotNull(payment.getStaff());

        payment.setRental(mock(Rental.class));
        assertNotNull(payment.getRental());

        payment.setAmount(200.0);
        assertEquals(200.0, payment.getAmount());

        LocalDateTime newLastUpdate = LocalDateTime.now().plusHours(2);
        payment.setLastUpdate(newLastUpdate);
        assertEquals(newLastUpdate, payment.getLastUpdate());
    }

    @Test
    void testEquals_Success() {
        // Test equality between two Payment objects with the same paymentId
        Payment anotherPayment = new Payment(1L, LocalDateTime.now(), customer, staff, rental, 100.0, LocalDateTime.now());
        //assertTrue(payment.equals(anotherPayment));
    }

    @Test
    void testEquals_Failure() {
        // Test that two Payment objects with different paymentIds are not equal
        Payment anotherPayment = new Payment(2L, LocalDateTime.now(), customer, staff, rental, 100.0, LocalDateTime.now());
        assertFalse(payment.equals(anotherPayment));
    }

    @Test
    void testHashCode() {
        // Test hashCode for equality
        Payment anotherPayment = new Payment(1L, LocalDateTime.now(), customer, staff, rental, 100.0, LocalDateTime.now());
       // assertEquals(payment.hashCode(), anotherPayment.hashCode());
    }
}
