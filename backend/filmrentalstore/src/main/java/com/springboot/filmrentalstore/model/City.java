package com.springboot.filmrentalstore.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "city")
@Data
@NoArgsConstructor
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cityId;

    @Column(nullable = false, length = 50)
    private String city;

    @ManyToOne
    @JoinColumn(name = "country_id", nullable = false)
    private Country country; // Correct relationship

    @Column(name = "last_update", nullable = false)
    @Convert(converter = LocalDateTimeAttributeConverter.class)
    private LocalDateTime lastUpdate;
}