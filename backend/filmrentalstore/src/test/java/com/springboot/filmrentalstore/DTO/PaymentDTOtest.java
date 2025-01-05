package com.springboot.filmrentalstore.DTO;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.springboot.filmrentalstore.model.Payment;

class PaymentDTOTest {

    @Test
    void testGetterAndSetter() {
        // Arrange
        PaymentDTO paymentDTO = new PaymentDTO();
        Long expectedPaymentId = 1L;
        LocalDateTime expectedPaymentDate = LocalDateTime.now();
        CustomerDTO expectedCustomer = new CustomerDTO();
        StaffDTO expectedStaff = new StaffDTO();
        RentalDTO expectedRental = new RentalDTO();
        Double expectedAmount = 100.50;
        LocalDateTime expectedLastUpdate = LocalDateTime.now();
        List<Payment> expectedPayments = new ArrayList<>();
        List<Payment> expectedStaffPayments = new ArrayList<>();
        List<Payment> expectedRentalPayments = new ArrayList<>();

        // Act
        paymentDTO.setPaymentId(expectedPaymentId);
        paymentDTO.setPaymentDate(expectedPaymentDate);
        paymentDTO.setCustomer(expectedCustomer);
        paymentDTO.setStaff(expectedStaff);
        paymentDTO.setRental(expectedRental);
        paymentDTO.setAmount(expectedAmount);
        paymentDTO.setLastUpdate(expectedLastUpdate);

        // Assert
        assertEquals(expectedPaymentId, paymentDTO.getPaymentId());
        assertEquals(expectedPaymentDate, paymentDTO.getPaymentDate());
        assertEquals(expectedCustomer, paymentDTO.getCustomer());
        assertEquals(expectedStaff, paymentDTO.getStaff());
        assertEquals(expectedRental, paymentDTO.getRental());
        assertEquals(expectedAmount, paymentDTO.getAmount());
        assertEquals(expectedLastUpdate, paymentDTO.getLastUpdate());
    }

    @Test
    void testDefaultConstructor() {
        // Act
        PaymentDTO paymentDTO = new PaymentDTO();

        // Assert
        assertNull(paymentDTO.getPaymentId());
        assertNull(paymentDTO.getPaymentDate());
        assertNull(paymentDTO.getCustomer());
        assertNull(paymentDTO.getStaff());
        assertNull(paymentDTO.getRental());
        assertNull(paymentDTO.getAmount());
        assertNull(paymentDTO.getLastUpdate());
    }

    @Test
    void testValidations() {
        // Arrange
        PaymentDTO paymentDTO = new PaymentDTO();

        // Act & Assert: Test invalid values for amount
        assertThrows(IllegalArgumentException.class, () -> {
            paymentDTO.setAmount(-10.0); // Invalid amount
            if (paymentDTO.getAmount() <= 0) {
                throw new IllegalArgumentException("Amount must be greater than 0 and positive.");
            }
        });

        // Act & Assert: Test null values for required fields
        assertThrows(NullPointerException.class, () -> {
            paymentDTO.setPaymentDate(null);
            if (paymentDTO.getPaymentDate() == null) {
                throw new NullPointerException("Payment date cannot be null.");
            }
        });

        assertThrows(NullPointerException.class, () -> {
            paymentDTO.setCustomer(null);
            if (paymentDTO.getCustomer() == null) {
                throw new NullPointerException("Customer cannot be null.");
            }
        });

        assertThrows(NullPointerException.class, () -> {
            paymentDTO.setStaff(null);
            if (paymentDTO.getStaff() == null) {
                throw new NullPointerException("Staff cannot be null.");
            }
        });

        assertThrows(NullPointerException.class, () -> {
            paymentDTO.setRental(null);
            if (paymentDTO.getRental() == null) {
                throw new NullPointerException("Rental cannot be null.");
            }
        });
    }
}
