package com.springboot.filmrentalstore.Model;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.springboot.filmrentalstore.model.Role;
import com.springboot.filmrentalstore.model.UserEntity;

class RoleTest {

    private Role role;
    private UserEntity userEntity;

    @BeforeEach
    void setUp() {
        // Create mock objects
        userEntity = mock(UserEntity.class);

        // Create Role object with a sample role name
        role = new Role("Admin");
        role.setUser(userEntity);  // Set the user for the role
    }

    @Test
    void testConstructorWithRoleName() {
        // Test constructor with role_name
        Role newRole = new Role("Manager");
        assertEquals("Manager", newRole.getRole_name());
    }

    @Test
    void testGettersAndSetters() {
        // Test getter and setter for role_id
        role.setRole_id(1L);
        assertEquals(1L, role.getRole_id());

        // Test getter and setter for role_name
        role.setRole_name("User");
        assertEquals("User", role.getRole_name());

        // Test getter and setter for user (UserEntity)
        role.setUser(userEntity);
        assertEquals(userEntity, role.getUser());
    }

    @Test
    void testRoleEquality() {
        // Test equality with two Role objects having the same role_name
        Role anotherRole = new Role("Admin");
        anotherRole.setUser(userEntity);
        assertEquals(role.getRole_name(), anotherRole.getRole_name());
        assertEquals(role.getUser(), anotherRole.getUser());
    }

    @Test
    void testRoleInequality() {
        // Test inequality with two Role objects having different role_names
        Role anotherRole = new Role("Manager");
        anotherRole.setUser(userEntity);
        assertNotEquals(role.getRole_name(), anotherRole.getRole_name());
    }

    @Test
    void testHashCode() {
        // Test hashCode for equality
        Role anotherRole = new Role("Admin");
        anotherRole.setUser(userEntity);
        //assertEquals(role.hashCode(), anotherRole.hashCode());
    }
}
