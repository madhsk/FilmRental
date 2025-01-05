package com.springboot.filmrentalstore.initializer;


import static org.mockito.Mockito.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.context.event.ContextRefreshedEvent;
import com.springboot.filmrentalstore.repo.RoleRepo;
import com.springboot.filmrentalstore.repo.UserRepo;
import com.springboot.filmrentalstore.model.Role;
import com.springboot.filmrentalstore.model.UserEntity;

import java.util.Arrays;

class DataInitializerTest {

    @InjectMocks
    private DataInitializer dataInitializer;

    @Mock
    private RoleRepo roleRepository;

    @Mock
    private UserRepo userRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @Mock
    private ContextRefreshedEvent contextRefreshedEvent;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testOnApplicationEvent() {
        // Arrange
        Role adminRole = new Role("ROLE_ADMIN");
        Role userRole = new Role("ROLE_USER");
        Role staffRole = new Role("ROLE_STAFF");

        when(roleRepository.saveAll(anyList())).thenReturn(Arrays.asList(adminRole, userRole, staffRole));

        UserEntity adminUser = new UserEntity();
        adminUser.setUsername("admin");
        adminUser.setPassword("encodedPassword1");
        adminUser.setRoles(Arrays.asList(adminRole, userRole));

        UserEntity normalUser = new UserEntity();
        normalUser.setUsername("user");
        normalUser.setPassword("encodedPassword2");
        normalUser.setRoles(Arrays.asList(userRole));

        when(passwordEncoder.encode("password@123")).thenReturn("encodedPassword1");
        when(passwordEncoder.encode("password@12345")).thenReturn("encodedPassword2");

        // Act
        dataInitializer.onApplicationEvent(contextRefreshedEvent);

//        // Assert
//        verify(roleRepository, times(1)).saveAll(anyList());
//        verify(userRepository, times(1)).saveAll(anyList());
    }
}
