package com.springboot.filmrentalstore.Repo;

import com.springboot.filmrentalstore.model.Actor;
import com.springboot.filmrentalstore.repo.ActorRepo;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class ActorRepoTest {

    @Mock
    private ActorRepo actorRepo;

    @Test
    void testFindByLastName() {
        // Initialize mocks
        MockitoAnnotations.openMocks(this);

        // Test data
        String lastName = "Smith";
        List<Actor> actors = Arrays.asList(
                new Actor(1L, "John", "Smith", null),
                new Actor(2L, "Jane", "Smith", null)
        );

        // Mock behavior
        when(actorRepo.findByLastName(lastName)).thenReturn(actors);

        // Test the method
        List<Actor> result = actorRepo.findByLastName(lastName);

        // Verify results
        assertEquals(2, result.size());
        assertEquals("Smith", result.get(0).getLastName());
        assertEquals("John", result.get(0).getFirstName());
    }

    @Test
    void testFindByFirstName() {
        // Initialize mocks
        MockitoAnnotations.openMocks(this);

        // Test data
        String firstName = "John";
        List<Actor> actors = Arrays.asList(
                new Actor(1L, "John", "Smith", null),
                new Actor(2L, "John", "Doe", null)
        );

        // Mock behavior
        when(actorRepo.findByFirstName(firstName)).thenReturn(actors);

        // Test the method
        List<Actor> result = actorRepo.findByFirstName(firstName);

        // Verify results
        assertEquals(2, result.size());
        assertEquals("John", result.get(0).getFirstName());
        assertEquals("Smith", result.get(0).getLastName());
    }
}
