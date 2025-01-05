package com.springboot.filmrentalstore.DTO;

import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.*;

class ActorDTOTest {

    @Test
    void testActorDTO_NoArgsConstructor() {
        ActorDTO actor = new ActorDTO();

        assertNull(actor.getActorId());
        assertNull(actor.getFirstName());
        assertNull(actor.getLastName());
        assertNull(actor.getLastUpdate());
    }

    @Test
    void testActorDTO_AllArgsConstructorWithoutLastUpdate() {
        ActorDTO actor = new ActorDTO(1L, "John", "Doe");

        assertEquals(1L, actor.getActorId());
        assertEquals("John", actor.getFirstName());
        assertEquals("Doe", actor.getLastName());
        assertNull(actor.getLastUpdate());
    }

    @Test
    void testActorDTO_AllArgsConstructorWithLastUpdate() {
        LocalDateTime lastUpdate = LocalDateTime.now();
        ActorDTO actor = new ActorDTO(1L, "John", "Doe", lastUpdate);

        assertEquals(1L, actor.getActorId());
        assertEquals("John", actor.getFirstName());
        assertEquals("Doe", actor.getLastName());
        assertEquals(lastUpdate, actor.getLastUpdate());
    }

    @Test
    void testActorDTO_SettersAndGetters() {
        LocalDateTime lastUpdate = LocalDateTime.now();
        ActorDTO actor = new ActorDTO();

        actor.setActorId(1L);
        actor.setFirstName("John");
        actor.setLastName("Doe");
        actor.setLastUpdate(lastUpdate);

        assertEquals(1L, actor.getActorId());
        assertEquals("John", actor.getFirstName());
        assertEquals("Doe", actor.getLastName());
        assertEquals(lastUpdate, actor.getLastUpdate());
    }
}
