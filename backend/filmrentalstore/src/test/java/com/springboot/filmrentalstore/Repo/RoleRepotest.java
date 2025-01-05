package com.springboot.filmrentalstore.Repo;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.springboot.filmrentalstore.model.Role;
import com.springboot.filmrentalstore.repo.RoleRepo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

class RoleRepoTest {

    @Mock
    private RoleRepo roleRepo;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindByRoleName() {
        // Arrange
        String roleName = "ADMIN";
        Role role = new Role();
        role.setRole_id(1L);
        role.setRole_name(roleName);

        when(roleRepo.findByRoleName(roleName)).thenReturn(role);

        // Act
        Role foundRole = roleRepo.findByRoleName(roleName);

        // Assert
        assertNotNull(foundRole);
        assertEquals(roleName, foundRole.getRole_name());
        assertEquals(1L, foundRole.getRole_id());
        verify(roleRepo, times(1)).findByRoleName(roleName);
    }

    @Test
    void testFindByRoleName_WhenRoleNotFound() {
        // Arrange
        String roleName = "USER";

        when(roleRepo.findByRoleName(roleName)).thenReturn(null);

        // Act
        Role foundRole = roleRepo.findByRoleName(roleName);

        // Assert
        assertNull(foundRole);
        verify(roleRepo, times(1)).findByRoleName(roleName);
    }

    @Test
    void testSaveRole() {
        // Arrange
        Role role = new Role();
        role.setRole_id(1L);
        role.setRole_name("ADMIN");

        when(roleRepo.save(role)).thenReturn(role);

        // Act
        Role savedRole = roleRepo.save(role);

        // Assert
        assertNotNull(savedRole);
        assertEquals(1L, savedRole.getRole_id());
        assertEquals("ADMIN", savedRole.getRole_name());
        verify(roleRepo, times(1)).save(role);
    }

    @Test
    void testFindById() {
        // Arrange
        Long roleId = 1L;
        Role role = new Role();
        role.setRole_id(roleId);
        role.setRole_name("ADMIN");

        when(roleRepo.findById(roleId)).thenReturn(Optional.of(role));

        // Act
        Optional<Role> foundRole = roleRepo.findById(roleId);

        // Assert
        assertTrue(foundRole.isPresent());
        assertEquals(roleId, foundRole.get().getRole_id());
        assertEquals("ADMIN", foundRole.get().getRole_name());
        verify(roleRepo, times(1)).findById(roleId);
    }

    @Test
    void testDeleteRole() {
        // Arrange
        Role role = new Role();
        role.setRole_id(1L);
        role.setRole_name("ADMIN");

        // Act
        roleRepo.delete(role);

        // Assert
        verify(roleRepo, times(1)).delete(role);
    }
}
