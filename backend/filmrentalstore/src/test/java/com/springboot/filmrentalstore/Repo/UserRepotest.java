package com.springboot.filmrentalstore.Repo;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.springboot.filmrentalstore.model.UserEntity;
import com.springboot.filmrentalstore.repo.UserRepo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

class UserRepoTest {

    @Mock
    private UserRepo userRepo;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindByUsername() {
        // Arrange
        String username = "john_doe";
        UserEntity user = new UserEntity();
        user.setUser_id(1L);
        user.setUsername(username);

        when(userRepo.findByUsername(username)).thenReturn(Optional.of(user));

        // Act
        Optional<UserEntity> foundUser = userRepo.findByUsername(username);

        // Assert
        assertTrue(foundUser.isPresent());
        assertEquals(username, foundUser.get().getUsername());
        assertEquals(1L, foundUser.get().getUser_id());
        verify(userRepo, times(1)).findByUsername(username);
    }

    @Test
    void testFindByUsername_NotFound() {
        // Arrange
        String username = "non_existent_user";

        when(userRepo.findByUsername(username)).thenReturn(Optional.empty());

        // Act
        Optional<UserEntity> foundUser = userRepo.findByUsername(username);

        // Assert
        assertFalse(foundUser.isPresent());
        verify(userRepo, times(1)).findByUsername(username);
    }

    @Test
    void testSaveUser() {
        // Arrange
        UserEntity user = new UserEntity();
        user.setUser_id(1L);
        user.setUsername("john_doe");

        when(userRepo.save(user)).thenReturn(user);

        // Act
        UserEntity savedUser = userRepo.save(user);

        // Assert
        assertNotNull(savedUser);
        assertEquals(1L, savedUser.getUser_id());
        assertEquals("john_doe", savedUser.getUsername());
        verify(userRepo, times(1)).save(user);
    }

    @Test
    void testFindById() {
        // Arrange
        Long userId = 1L;
        UserEntity user = new UserEntity();
        user.setUser_id(userId);
        user.setUsername("john_doe");

        when(userRepo.findById(userId)).thenReturn(Optional.of(user));

        // Act
        Optional<UserEntity> foundUser = userRepo.findById(userId);

        // Assert
        assertTrue(foundUser.isPresent());
        assertEquals(userId, foundUser.get().getUser_id());
        assertEquals("john_doe", foundUser.get().getUsername());
        verify(userRepo, times(1)).findById(userId);
    }

    @Test
    void testDeleteUser() {
        // Arrange
        UserEntity user = new UserEntity();
        user.setUser_id(1L);
        user.setUsername("john_doe");

        // Act
        userRepo.delete(user);

        // Assert
        verify(userRepo, times(1)).delete(user);
    }

    @Test
    void testDeleteById() {
        // Arrange
        Long userId = 1L;

        // Act
        userRepo.deleteById(userId);

        // Assert
        verify(userRepo, times(1)).deleteById(userId);
    }
}
