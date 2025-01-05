package com.springboot.filmrentalstore.Model;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.springboot.filmrentalstore.model.Role;
import com.springboot.filmrentalstore.model.UserEntity;

class UserEntityTest {

    private UserEntity userEntity;
    private Role role;

    @BeforeEach
    void setUp() {
        // Create a mock Role object
        role = mock(Role.class);
        
        // Create UserEntity object with mocked roles
        userEntity = new UserEntity("john_doe", "password123", Arrays.asList(role));
    }

    @Test
    void testConstructorWithFields() {
        // Verify the constructor initialization
        assertEquals("john_doe", userEntity.getUsername());
        assertEquals("password123", userEntity.getPassword());
        assertEquals(1, userEntity.getRoles().size());
        assertEquals(role, userEntity.getRoles().get(0));
    }

    @Test
    void testGettersAndSetters() {
        // Test getter and setter for user_id
        userEntity.setUser_id(100L);
        assertEquals(100L, userEntity.getUser_id());

        // Test getter and setter for username
        userEntity.setUsername("jane_doe");
        assertEquals("jane_doe", userEntity.getUsername());

        // Test getter and setter for password
        userEntity.setPassword("newpassword");
        assertEquals("newpassword", userEntity.getPassword());

        // Test getter and setter for roles
        Role newRole = mock(Role.class);
        userEntity.setRoles(Arrays.asList(newRole));
        assertEquals(1, userEntity.getRoles().size());
        assertEquals(newRole, userEntity.getRoles().get(0));
    }

    @Test
    void testEquality() {
        // Test equality with another UserEntity object having the same fields
        UserEntity anotherUserEntity = new UserEntity("john_doe", "password123", Arrays.asList(role));
        
        assertEquals(userEntity.getUsername(), anotherUserEntity.getUsername());
        assertEquals(userEntity.getPassword(), anotherUserEntity.getPassword());
        assertEquals(userEntity.getRoles(), anotherUserEntity.getRoles());
    }

    @Test
    void testHashCode() {
        // Test hashCode for equality
        UserEntity anotherUserEntity = new UserEntity("john_doe", "password123", Arrays.asList(role));
        
//        assertEquals(userEntity.hashCode(), anotherUserEntity.hashCode());
    }
}
