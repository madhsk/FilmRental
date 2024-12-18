package com.springboot.filmrentalstore.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "customer")
@Data
@NoArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="customer_id",nullable = false)
    private int customerId;

    @Column(name = "store_id", nullable = false)
    private int storeId;

    @Column(name="first_name", nullable = false, length = 45)
    private String firstName;

    @Column(name="last_name",nullable = false, length = 45)
    private String lastName;

    @Column(name="email",length = 50)
    private String email;

    @ManyToOne
    @JoinColumn(name = "address_id", nullable = false)
    private Address address; 

    @Column(name="active",nullable = false)
    private Boolean active;

    @Column(name = "create_date", nullable = false)
    private Date createDate;

    @Column(name = "last_update")
    @Convert(converter = LocalDateTimeAttributeConverter.class)
    private LocalDateTime lastUpdate;
}
