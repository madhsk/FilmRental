package com.springboot.filmrentalstore.exception;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InvalidInputExceptionTest {

    @Test
    void testExceptionMessage() {
        // Given a specific message
        String message = "Invalid input provided!";
        
        // When the exception is thrown
        InvalidInputException exception = assertThrows(InvalidInputException.class, () -> {
            throw new InvalidInputException(message);
        });
        
        // Then the exception message should match the provided message
        assertEquals(message, exception.getMessage());
    }
    
    @Test
    void testExceptionWithoutMessage() {
        // When the exception is thrown without a message
        InvalidInputException exception = assertThrows(InvalidInputException.class, () -> {
            throw new InvalidInputException(null);
        });

        // Then the message should be null
        assertNull(exception.getMessage());
    }
}
