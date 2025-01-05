package com.springboot.filmrentalstore.exception;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UnauthorizedExceptionTest {

    @Test
    void testExceptionMessage() {
        // Given a specific message
        String message = "Unauthorized access!";
        
        // When the exception is thrown
        UnauthorizedException exception = assertThrows(UnauthorizedException.class, () -> {
            throw new UnauthorizedException(message);
        });
        
        // Then the exception message should match the provided message
        assertEquals(message, exception.getMessage());
    }

    @Test
    void testExceptionWithoutMessage() {
        // When the exception is thrown with no message
        UnauthorizedException exception = assertThrows(UnauthorizedException.class, () -> {
            throw new UnauthorizedException(null);
        });

        // Then the message should be null
        assertNull(exception.getMessage());
    }
}
