package com.springboot.filmrentalstore.DTO;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

class RegisterDTOTest {

    @Test
    void testGetterAndSetter() {
        // Arrange
        RegisterDTO registerDTO = new RegisterDTO();
        String expectedUsername = "testUser";
        String expectedEmail = "testuser@example.com";
        String expectedPassword = "securePassword123";
        Set<String> expectedRoles = new HashSet<>();
        expectedRoles.add("ROLE_USER");
        expectedRoles.add("ROLE_ADMIN");

        // Act
        registerDTO.setUsername(expectedUsername);
        registerDTO.setEmail(expectedEmail);
        registerDTO.setPassword(expectedPassword);
        registerDTO.setRole(expectedRoles);

        // Assert
        assertEquals(expectedUsername, registerDTO.getUsername());
        assertEquals(expectedEmail, registerDTO.getEmail());
        assertEquals(expectedPassword, registerDTO.getPassword());
        assertEquals(expectedRoles, registerDTO.getRole());
    }

    @Test
    void testDefaultConstructor() {
        // Act
        RegisterDTO registerDTO = new RegisterDTO();

        // Assert
        assertNull(registerDTO.getUsername());
        assertNull(registerDTO.getEmail());
        assertNull(registerDTO.getPassword());
        assertNull(registerDTO.getRole());
    }

    @Test
    void testValidationConstraints() {
        // Arrange
        RegisterDTO registerDTO = new RegisterDTO();
        
        registerDTO.setUsername("us"); // Less than 3 characters
        registerDTO.setEmail("invalid-email"); // Invalid email format
        registerDTO.setPassword("123"); // Less than 6 characters

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            if (registerDTO.getUsername().length() < 3 || registerDTO.getUsername().length() > 20) {
                throw new IllegalArgumentException("Username must be between 3 and 20 characters");
            }
        });

        assertThrows(IllegalArgumentException.class, () -> {
            if (!registerDTO.getEmail().contains("@") || registerDTO.getEmail().length() > 50) {
                throw new IllegalArgumentException("Invalid email format or exceeds max length of 50");
            }
        });

        assertThrows(IllegalArgumentException.class, () -> {
            if (registerDTO.getPassword().length() < 6 || registerDTO.getPassword().length() > 40) {
                throw new IllegalArgumentException("Password must be between 6 and 40 characters");
            }
        });
    }
}
