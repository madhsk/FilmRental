package com.springboot.filmrentalstore.Model;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.springboot.filmrentalstore.model.AuthenticateUser;

class AuthenticateUsertest {

    @Test
    void testDefaultConstructor() {
        // Act
        AuthenticateUser authenticateUser = new AuthenticateUser();

        // Assert
        assertNotNull(authenticateUser);
        assertNull(authenticateUser.getUserName());
        assertNull(authenticateUser.getPassword());
        assertNull(authenticateUser.getRole());
    }

    @Test
    void testSetUserName() {
        // Arrange
        AuthenticateUser authenticateUser = new AuthenticateUser();
        String userName = "testUser";

        // Act
        authenticateUser.setUserName(userName);

        // Assert
        assertEquals(userName, authenticateUser.getUserName());
    }

    @Test
    void testSetPassword() {
        // Arrange
        AuthenticateUser authenticateUser = new AuthenticateUser();
        String password = "password123";

        // Act
        authenticateUser.setPassword(password);

        // Assert
        assertEquals(password, authenticateUser.getPassword());
    }

    @Test
    void testSetRole() {
        // Arrange
        AuthenticateUser authenticateUser = new AuthenticateUser();
        String role = "ADMIN";

        // Act
        authenticateUser.setRole(role);

        // Assert
        assertEquals(role, authenticateUser.getRole());
    }
}
