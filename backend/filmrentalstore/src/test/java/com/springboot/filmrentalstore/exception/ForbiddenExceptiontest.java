package com.springboot.filmrentalstore.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ForbiddenExceptionTest {

    @Test
    void testExceptionMessage() {
        // Test that the exception is thrown with the correct message
        String message = "Forbidden access!";
        
        ForbiddenException exception = assertThrows(ForbiddenException.class, () -> {
            throw new ForbiddenException(message);
        });
        
        // Verify that the exception message is correct
        assertEquals(message, exception.getMessage());
    }
    
    @Test
    void testExceptionWithoutMessage() {
        // Test that the exception is thrown without a message
        ForbiddenException exception = assertThrows(ForbiddenException.class, () -> {
            throw new ForbiddenException(null);
        });

        // Verify that the exception does not throw null message unexpectedly
        assertNull(exception.getMessage());
    }
}
