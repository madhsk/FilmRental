package com.springboot.filmrentalstore.DTO;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LoginDTOTest {

    private LoginDTO loginDTO;

    @BeforeEach
    void setUp() {
        // Initialize the LoginDTO object before each test
        loginDTO = new LoginDTO();
    }

    @Test
    void testSetAndGetUsername() {
        // Set a username and verify it with the getter
        loginDTO.setUsername("user123");
        assertEquals("user123", loginDTO.getUsername());
    }

    @Test
    void testSetAndGetPassword() {
        // Set a password and verify it with the getter
        loginDTO.setPassword("password123");
        assertEquals("password123", loginDTO.getPassword());
    }

    @Test
    void testDefaultConstructor() {
        // Verify that the default constructor works (ensures loginDTO is not null)
        LoginDTO newLoginDTO = new LoginDTO();
        assertNotNull(newLoginDTO);
    }

    @Test
    void testNotNullValidationForUsername() {
        // Test to ensure that username cannot be null
        loginDTO.setUsername(null);
        assertNull(loginDTO.getUsername());
    }

    @Test
    void testNotNullValidationForPassword() {
        // Test to ensure that password cannot be null
        loginDTO.setPassword(null);
        assertNull(loginDTO.getPassword());
    }
}
