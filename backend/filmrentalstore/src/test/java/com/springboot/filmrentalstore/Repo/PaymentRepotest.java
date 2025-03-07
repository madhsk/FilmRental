package com.springboot.filmrentalstore.Repo;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.springboot.filmrentalstore.model.Payment;
import com.springboot.filmrentalstore.repo.PaymentRepo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

class PaymentRepoTest {

    @Mock
    private PaymentRepo paymentRepo;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSavePayment() {
        // Arrange
        Payment payment = new Payment();
        //payment.setId(1L);
        payment.setAmount(100.0);

        when(paymentRepo.save(payment)).thenReturn(payment);

        // Act
        Payment savedPayment = paymentRepo.save(payment);

        // Assert
        assertNotNull(savedPayment);
        //assertEquals(1L, savedPayment.getId());
        assertEquals(100.0, savedPayment.getAmount());
        verify(paymentRepo, times(1)).save(payment);
    }

    @Test
    void testFindById() {
        // Arrange
        Long paymentId = 1L;
        Payment payment = new Payment();
        //payment.setId(paymentId);
        payment.setAmount(100.0);

        when(paymentRepo.findById(paymentId)).thenReturn(Optional.of(payment));

        // Act
        Optional<Payment> foundPayment = paymentRepo.findById(paymentId);

        // Assert
        assertTrue(foundPayment.isPresent());
        //assertEquals(paymentId, foundPayment.get().getId());
        assertEquals(100.0, foundPayment.get().getAmount());
        verify(paymentRepo, times(1)).findById(paymentId);
    }

    @Test
    void testFindById_WhenPaymentNotFound() {
        // Arrange
        Long paymentId = 999L;

        when(paymentRepo.findById(paymentId)).thenReturn(Optional.empty());

        // Act
        Optional<Payment> foundPayment = paymentRepo.findById(paymentId);

        // Assert
        assertFalse(foundPayment.isPresent());
        verify(paymentRepo, times(1)).findById(paymentId);
    }

    @Test
    void testDeletePayment() {
        // Arrange
        Payment payment = new Payment();
       // payment.setId(1L);
        payment.setAmount(100.0);

        // Act
        paymentRepo.delete(payment);

        // Assert
        verify(paymentRepo, times(1)).delete(payment);
    }
}
