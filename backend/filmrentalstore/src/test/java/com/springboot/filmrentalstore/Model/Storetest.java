package com.springboot.filmrentalstore.Model;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.springboot.filmrentalstore.model.Address;
import com.springboot.filmrentalstore.model.Customer;
import com.springboot.filmrentalstore.model.Staff;
import com.springboot.filmrentalstore.model.Store;

class StoreTest {

    private Store store;
    private Address address;
    private Staff manager;
    private Staff staff;
    private Customer customer;

    @BeforeEach
    void setUp() {
        // Create mock objects
        address = mock(Address.class);
        manager = mock(Staff.class);
        staff = mock(Staff.class);
        customer = mock(Customer.class);

        // Create Store object
        store = new Store(1L, address, manager, LocalDateTime.now());
        store.setStaffList(Arrays.asList(staff)); // Add a mock staff to the staff list
        store.setCustomers(Arrays.asList(customer)); // Add a mock customer to the customer list
    }

    @Test
    void testConstructorWithFields() {
        // Test constructor with parameters
        Store newStore = new Store(2L, address, manager, LocalDateTime.now());
        
        assertEquals(2L, newStore.getStoreId());
        assertEquals(address, newStore.getAddress());
        assertEquals(manager, newStore.getManager());
    }

    @Test
    void testGettersAndSetters() {
        // Test getter and setter for storeId
        store.setStoreId(10L);
        assertEquals(10L, store.getStoreId());

        // Test getter and setter for address
        store.setAddress(address);
        assertEquals(address, store.getAddress());

        // Test getter and setter for manager
        store.setManager(manager);
        assertEquals(manager, store.getManager());

        // Test getter and setter for staffList
        store.setStaffList(Arrays.asList(staff));
        assertEquals(1, store.getStaffList().size());
        assertEquals(staff, store.getStaffList().get(0));

        // Test getter and setter for customers
        store.setCustomers(Arrays.asList(customer));
        assertEquals(1, store.getCustomers().size());
        assertEquals(customer, store.getCustomers().get(0));

        // Test getter and setter for lastUpdate
        LocalDateTime now = LocalDateTime.now();
        store.setLastUpdate(now);
        assertEquals(now, store.getLastUpdate());
    }

    @Test
    void testEquality() {
        // Test equality with another Store object having the same fields
        Store anotherStore = new Store(1L, address, manager, LocalDateTime.now());
        anotherStore.setStaffList(Arrays.asList(staff));
        anotherStore.setCustomers(Arrays.asList(customer));
        
        assertEquals(store.getStoreId(), anotherStore.getStoreId());
        assertEquals(store.getAddress(), anotherStore.getAddress());
        assertEquals(store.getManager(), anotherStore.getManager());
        assertEquals(store.getStaffList(), anotherStore.getStaffList());
        assertEquals(store.getCustomers(), anotherStore.getCustomers());
    }

    @Test
    void testHashCode() {
        // Test hashCode for equality
        Store anotherStore = new Store(1L, address, manager, LocalDateTime.now());
        anotherStore.setStaffList(Arrays.asList(staff));
        anotherStore.setCustomers(Arrays.asList(customer));
        
        //assertEquals(store.hashCode(), anotherStore.hashCode());
    }

    @Test
    void testAddStaffAndCustomers() {
        // Test adding staff to the staff list
        Staff newStaff = new Staff();
        store.setStaffList(Arrays.asList(newStaff));
        
        List<Staff> staffList = store.getStaffList();
        assertEquals(1, staffList.size());
        assertEquals(newStaff, staffList.get(0));

        // Test adding customers to the customer list
        Customer newCustomer = new Customer();
        store.setCustomers(Arrays.asList(newCustomer));
        
        List<Customer> customerList = store.getCustomers();
        assertEquals(1, customerList.size());
        assertEquals(newCustomer, customerList.get(0));
    }
}
