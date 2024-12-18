package com.springboot.filmrentalstore.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "film_actor")
@Data
@NoArgsConstructor
public class FilmActor {
	
	
	@EmbeddedId
	private FilmActorId filmActorId;
	
	@Column(name ="last_update")
	private LocalDateTime lastUpdate;

}


@Embeddable
class FilmActorId {
	

	@ManyToOne
	@JsonBackReference
	@JoinColumn(name = "actor_id", referencedColumnName = "actor_id", nullable = false)
	private Actor actor;
	
	@ManyToOne
	@JsonBackReference
	@JoinColumn(name = "film_id", referencedColumnName = "film_id", nullable = false)
	private Film film;

}


