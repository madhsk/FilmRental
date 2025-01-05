package com.springboot.filmrentalstore.filter;


import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class JwtTokenTest {

    private JwtToken jwtToken;

    @BeforeEach
    void setUp() {
        jwtToken = new JwtToken();
    }

    @Test
    void testGenerateToken() {
        // Arrange
        String userName = "testUser";
        String password = "testPassword";
        String role = "ROLE_USER";

        // Act
        jwtToken.generateToken(userName, password, role);
        String generatedToken = jwtToken.getToken();

        // Assert
        assertNotNull(generatedToken);
    }

    @Test
    void testGetSecretKey() {
        // Act
        String secretKey = jwtToken.getSecretKey();

        // Assert
        assertNotNull(secretKey);
        assertEquals("@@#!film##rental==**$%^&*", secretKey);
    }

    @Test
    void testValidateValidToken() {
        // Arrange
        String userName = "testUser";
        String password = "testPassword";
        String role = "ROLE_USER";
        jwtToken.generateToken(userName, password, role);
        String generatedToken = jwtToken.getToken();

        // Act
        boolean isValid = jwtToken.validate(generatedToken);

        // Assert
        assertTrue(isValid);
    }

    @Test
    void testValidateInvalidToken() {
        // Arrange
        String invalidToken = "invalidToken";

        // Act
        boolean isValid = jwtToken.validate(invalidToken);

        // Assert
        assertFalse(isValid);
    }
}
