package com.springboot.filmrentalstore.exception;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ResponseTest {

    @Test
    void testConstructorAndGetters() {
        // Given specific values for code and message
        String expectedCode = "200";
        String expectedMessage = "Request was successful!";
        
        // When the Response object is created
        Response response = new Response(expectedCode, expectedMessage);
        
        // Then the getter methods should return the correct values
        assertEquals(expectedCode, response.getCode());
        assertEquals(expectedMessage, response.getMessage());
    }

    @Test
    void testSetters() {
        // Given a Response object
        Response response = new Response(null, null);
        
        // Set new values using the setter methods
        String newCode = "404";
        String newMessage = "Resource not found!";
        response.setCode(newCode);
        response.setMessage(newMessage);
        
        // Then the getter methods should return the updated values
        assertEquals(newCode, response.getCode());
        assertEquals(newMessage, response.getMessage());
    }

    @Test
    void testNullValues() {
        // When the Response object is created with null values
        Response response = new Response(null, null);
        
        // Then the getter methods should return null
        assertNull(response.getCode());
        assertNull(response.getMessage());
    }
}
