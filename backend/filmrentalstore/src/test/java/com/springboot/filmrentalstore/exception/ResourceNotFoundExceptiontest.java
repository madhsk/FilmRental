package com.springboot.filmrentalstore.exception;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ResourceNotFoundExceptionTest {

    @Test
    void testExceptionMessage() {
        // Given a specific message
        String message = "Resource not found!";
        
        // When the exception is thrown
        ResourceNotFoundException exception = assertThrows(ResourceNotFoundException.class, () -> {
            throw new ResourceNotFoundException(message);
        });
        
        // Then the exception message should match the provided message
        assertEquals(message, exception.getMessage());
    }

    @Test
    void testExceptionWithoutMessage() {
        // When the exception is thrown with no message
        ResourceNotFoundException exception = assertThrows(ResourceNotFoundException.class, () -> {
            throw new ResourceNotFoundException(null);
        });

        // Then the message should be null
        assertNull(exception.getMessage());
    }
}
