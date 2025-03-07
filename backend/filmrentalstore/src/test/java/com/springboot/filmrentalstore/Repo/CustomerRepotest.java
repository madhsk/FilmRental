package com.springboot.filmrentalstore.Repo;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import com.springboot.filmrentalstore.model.Customer;
import com.springboot.filmrentalstore.repo.CustomerRepo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

class CustomerRepotest {

    @Mock
    private CustomerRepo customerRepo;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindByFirstName() {
        // Arrange
        String firstName = "John";
        Customer customer1 = new Customer();
        //customer1.setId(1L);
        customer1.setFirstName("John");
        customer1.setLastName("Doe");

        Customer customer2 = new Customer();
        //customer2.setId(2L);
        customer2.setFirstName("John");
        customer2.setLastName("Smith");

        List<Customer> customers = Arrays.asList(customer1, customer2);
        when(customerRepo.findByFirstName(firstName)).thenReturn(customers);

        // Act
        List<Customer> result = customerRepo.findByFirstName(firstName);

        // Assert
        assertEquals(2, result.size());
        assertEquals("John", result.get(0).getFirstName());
        verify(customerRepo, times(1)).findByFirstName(firstName);
    }

    @Test
    void testFindByLastName() {
        // Arrange
        String lastName = "Doe";
        Customer customer = new Customer();
        //customer.setId(1L);
        customer.setFirstName("John");
        customer.setLastName("Doe");

        List<Customer> customers = List.of(customer);
        when(customerRepo.findByLastName(lastName)).thenReturn(customers);

        // Act
        List<Customer> result = customerRepo.findByLastName(lastName);

        // Assert
        assertEquals(1, result.size());
        assertEquals("Doe", result.get(0).getLastName());
        verify(customerRepo, times(1)).findByLastName(lastName);
    }

    @Test
    void testFindByEmail() {
        // Arrange
        String email = "john.doe@example.com";
        Customer customer = new Customer();
        //customer.setId(1L);
        customer.setFirstName("John");
        customer.setLastName("Doe");
        customer.setEmail(email);

        List<Customer> customers = List.of(customer);
        when(customerRepo.findByEmail(email)).thenReturn(customers);

        // Act
        List<Customer> result = customerRepo.findByEmail(email);

        // Assert
        assertEquals(1, result.size());
        assertEquals(email, result.get(0).getEmail());
        verify(customerRepo, times(1)).findByEmail(email);
    }
}
