package com.springboot.filmrentalstore.exception;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class ErrorDetailsTest {

    private ErrorDetails errorDetails;

    @BeforeEach
    void setUp() {
        // Initialize the ErrorDetails object before each test
        errorDetails = new ErrorDetails();
    }

    @Test
    void testSetAndGetMessage() {
        // Test setting and getting the message
        String message = "Resource not found";
        errorDetails.setMessage(message);
        assertEquals(message, errorDetails.getMessage());
    }

    @Test
    void testSetAndGetStatus() {
        // Test setting and getting the status
        int status = 404;
        errorDetails.setStatus(status);
        assertEquals(status, errorDetails.getStatus());
    }

    @Test
    void testSetAndGetTimestamp() {
        // Test setting and getting the timestamp
        LocalDateTime timestamp = LocalDateTime.now();
        errorDetails.setTimestamp(timestamp);
        assertEquals(timestamp, errorDetails.getTimestamp());
    }

    @Test
    void testConstructorWithArguments() {
        // Test constructor with arguments
        LocalDateTime timestamp = LocalDateTime.now();
        ErrorDetails errorDetails = new ErrorDetails("Internal Server Error", 500, timestamp);
        
        assertEquals("Internal Server Error", errorDetails.getMessage());
        assertEquals(500, errorDetails.getStatus());
        assertEquals(timestamp, errorDetails.getTimestamp());
    }

    @Test
    void testDefaultConstructor() {
        // Verify that the default constructor works and creates a valid object
        ErrorDetails errorDetails = new ErrorDetails();
        assertNotNull(errorDetails);
    }
}
