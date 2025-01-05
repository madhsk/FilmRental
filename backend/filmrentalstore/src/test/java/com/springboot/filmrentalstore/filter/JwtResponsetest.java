package com.springboot.filmrentalstore.filter;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class JwtResponseTest {

    @Test
    void testJwtResponseConstructorAndGetters() {
        // Arrange
        String token = "testToken";
        String username = "testUser";

        // Act
        JwtResponse jwtResponse = new JwtResponse(token, username);

        // Assert
        assertEquals(token, jwtResponse.getToken());
        assertEquals(username, jwtResponse.getUsername());
    }

    @Test
    void testSetToken() {
        // Arrange
        JwtResponse jwtResponse = new JwtResponse("initialToken", "testUser");
        String newToken = "newTestToken";

        // Act
        jwtResponse.setToken(newToken);

        // Assert
        assertEquals(newToken, jwtResponse.getToken());
    }

    @Test
    void testSetUsername() {
        // Arrange
        JwtResponse jwtResponse = new JwtResponse("testToken", "initialUser");
        String newUsername = "newTestUser";

        // Act
        jwtResponse.setUsername(newUsername);

        // Assert
        assertEquals(newUsername, jwtResponse.getUsername());
    }
}
