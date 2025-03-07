package com.springboot.filmrentalstore.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Staff {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // Auto-generate IDs
    private Long staffId;

    private String firstName;
    private String lastName;
    private String email;

    @ManyToOne
    @JoinColumn(name = "address_id")
    @JsonIgnore // Prevent infinite recursion
    private Address address;

    @ManyToOne
    @JoinColumn(name = "store_id")
    @JsonIgnore // Handle bidirectional relationships
    private Store store;

    private String username;
    private String password;
    private boolean active;
    private LocalDateTime lastUpdate;

    @OneToMany(mappedBy = "staff", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore // Prevent infinite recursion
    private List<Payment> staffPayments;

    public Staff() {
        super();
    }

    public Staff(Long staffId, String firstName, String lastName, String email, Address address, Store store,
                 String username, String password, boolean active, LocalDateTime lastUpdate) {
        super();
        this.staffId = staffId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.store = store;
        this.username = username;
        this.password = password;
        this.active = active;
        this.lastUpdate = lastUpdate;
    }

    public Long getStaffId() {
        return staffId;
    }

    public void setStaffId(Long staffId) {
        this.staffId = staffId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public LocalDateTime getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(LocalDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public List<Payment> getStaffPayments() {
        return staffPayments;
    }

    public void setStaffPayments(List<Payment> staffPayments) {
        this.staffPayments = staffPayments;
    }
}
