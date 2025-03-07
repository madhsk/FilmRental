package com.springboot.filmrentalstore.controller;

import com.springboot.filmrentalstore.DTO.ActorDTO;
import com.springboot.filmrentalstore.exception.*;
import com.springboot.filmrentalstore.model.*;
import com.springboot.filmrentalstore.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/actors")
public class ActorController {
    @Autowired
    private ActorService actorService;

    @GetMapping("/lastname/{ln}")
    public ResponseEntity<List<ActorDTO>> getActorsByLastName(@PathVariable String ln)
            throws InvalidInputException, ResourceNotFoundException {
        List<ActorDTO> actors = actorService.getActorsByLastName(ln);
        return new ResponseEntity<>(actors, HttpStatus.OK);
    }

    @GetMapping("/firstname/{fn}")
    public ResponseEntity<List<ActorDTO>> getActorsByFirstName(@PathVariable String fn)
            throws InvalidInputException, ResourceNotFoundException {
        List<ActorDTO> actors = actorService.getActorsByFirstName(fn);
        return new ResponseEntity<>(actors, HttpStatus.OK);
    }

    @PutMapping("/update/lastname/{actorId}")
    public ResponseEntity<Void> updateLastName(@PathVariable("actorId") Long actorId, @RequestBody Map<String, String> requestBody)
            throws ResourceNotFoundException, InvalidInputException {
        String lastName = requestBody.get("lastName");
        actorService.updateLastName(actorId, lastName);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/update/firstname/{actorId}")
    public ResponseEntity<Void> updateFirstName(@PathVariable("actorId") Long actorId, @RequestBody Map<String, String> requestBody)
            throws ResourceNotFoundException, InvalidInputException {
        String firstName = requestBody.get("firstName");
        actorService.updateFirstName(actorId, firstName);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/toptenbyfilmcount")
    public ResponseEntity<List<ActorDTO>> getTopTenActorsByFilmCount() throws ResourceNotFoundException {
        List<ActorDTO> actors = actorService.getTopTenActorsByFilmCount();
        return new ResponseEntity<>(actors, HttpStatus.OK);
    }

    @PostMapping("/post")
    public ResponseEntity<String> addActor(@RequestBody ActorDTO actorDTO) throws InvalidInputException {
        String response = actorService.addActor(actorDTO);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/{actorId}/film")
    public ResponseEntity<String> assignFilmToActor(@PathVariable("actorId") Long actorId, @RequestBody Collection<Long> filmIds) {
        System.out.println("Received request to assign films to actor.");
        System.out.println("Actor ID: " + actorId);
        System.out.println("Film IDs: " + filmIds);

        try {
            // Call the service method
            actorService.assignFilmToActor(actorId, filmIds);

            System.out.println("Films assigned successfully.");
            return ResponseEntity.ok("Films assigned to Actor successfully");
        } catch (ResourceNotFoundException e) {
            System.out.println("Error: Resource not found - " + e.getMessage());
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            System.out.println("Unexpected error occurred: " + e.getMessage());
            e.printStackTrace(); // Print the full stack trace for debugging
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal Server Error: " + e.getMessage());
        }
    }



    @GetMapping("/{actorId}/films")
    public ResponseEntity<List<Film>> getFilmsByActorId(@PathVariable("actorId") Long actorId) throws ResourceNotFoundException {
        List<Film> films = actorService.getFilmsByActorId(actorId); // Adjust service method accordingly
        return ResponseEntity.ok(films);
    }
}
