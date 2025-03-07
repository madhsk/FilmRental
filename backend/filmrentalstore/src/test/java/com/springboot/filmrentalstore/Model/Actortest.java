package com.springboot.filmrentalstore.Model;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

import com.springboot.filmrentalstore.model.Actor;

class Actortest {

    @Test
    void testActorConstructorAndGetters() {
        // Arrange
        Long actorId = 1L;
        String firstName = "John";
        String lastName = "Doe";
        LocalDateTime lastUpdate = LocalDateTime.now();

        // Act
        Actor actor = new Actor(actorId, firstName, lastName, lastUpdate);

        // Assert
        assertEquals(actorId, actor.getActorId());
        assertEquals(firstName, actor.getFirstName());
        assertEquals(lastName, actor.getLastName());
        assertEquals(lastUpdate, actor.getLastUpdate());
    }

    @Test
    void testSetActorId() {
        // Arrange
        Actor actor = new Actor();
        Long actorId = 2L;

        // Act
        actor.setActorId(actorId);

        // Assert
        assertEquals(actorId, actor.getActorId());
    }

    @Test
    void testSetFirstName() {
        // Arrange
        Actor actor = new Actor();
        String firstName = "Jane";

        // Act
        actor.setFirstName(firstName);

        // Assert
        assertEquals(firstName, actor.getFirstName());
    }

    @Test
    void testSetLastName() {
        // Arrange
        Actor actor = new Actor();
        String lastName = "Smith";

        // Act
        actor.setLastName(lastName);

        // Assert
        assertEquals(lastName, actor.getLastName());
    }

    @Test
    void testSetLastUpdate() {
        // Arrange
        Actor actor = new Actor();
        LocalDateTime beforeUpdate = LocalDateTime.now();

        // Act
        actor.setLastUpdate(LocalDateTime.now());
        LocalDateTime afterUpdate = actor.getLastUpdate();

        // Assert
        assertTrue(afterUpdate.isAfter(beforeUpdate) || afterUpdate.isEqual(beforeUpdate));
    }
}
