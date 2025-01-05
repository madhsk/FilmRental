package com.springboot.filmrentalstore.Repo;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.springboot.filmrentalstore.model.Address;
import com.springboot.filmrentalstore.model.City;
import com.springboot.filmrentalstore.model.Country;
import com.springboot.filmrentalstore.model.Staff;
import com.springboot.filmrentalstore.repo.StaffRepo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

class StaffRepotest {

    @Mock
    private StaffRepo staffRepo;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindByLastName() {
        // Arrange
        String lastName = "Doe";
        Staff staff1 = new Staff();
        staff1.setStaffId(1L);
        staff1.setLastName(lastName);

        Staff staff2 = new Staff();
        staff2.setStaffId(2L);
        staff2.setLastName(lastName);

        List<Staff> staffList = Arrays.asList(staff1, staff2);

        when(staffRepo.findByLastName(lastName)).thenReturn(staffList);

        // Act
        List<Staff> foundStaffList = staffRepo.findByLastName(lastName);

        // Assert
        assertNotNull(foundStaffList);
        assertEquals(2, foundStaffList.size());
        assertEquals(lastName, foundStaffList.get(0).getLastName());
        assertEquals(lastName, foundStaffList.get(1).getLastName());
        verify(staffRepo, times(1)).findByLastName(lastName);
    }

    @Test
    void testFindByEmail() {
        // Arrange
        String email = "john.doe@example.com";
        Staff staff = new Staff();
        staff.setStaffId(1L);
        staff.setEmail(email);

        when(staffRepo.findByEmail(email)).thenReturn(Arrays.asList(staff));

        // Act
        List<Staff> foundStaffList = staffRepo.findByEmail(email);

        // Assert
        assertNotNull(foundStaffList);
        assertEquals(1, foundStaffList.size());
        assertEquals(email, foundStaffList.get(0).getEmail());
        verify(staffRepo, times(1)).findByEmail(email);
    }

    @Test
    void testFindByFirstName() {
        // Arrange
        String firstName = "John";
        Staff staff = new Staff();
        staff.setStaffId(1L);
        staff.setFirstName(firstName);

        when(staffRepo.findByFirstName(firstName)).thenReturn(Arrays.asList(staff));

        // Act
        List<Staff> foundStaffList = staffRepo.findByFirstName(firstName);

        // Assert
        assertNotNull(foundStaffList);
        assertEquals(1, foundStaffList.size());
        assertEquals(firstName, foundStaffList.get(0).getFirstName());
        verify(staffRepo, times(1)).findByFirstName(firstName);
    }

    @Test
    void testFindByAddressPhone() {
        // Arrange
        String phoneNumber = "123-456-7890";
        Staff staff = new Staff();
        staff.setStaffId(1L);
        staff.setAddress(new Address());
        staff.getAddress().setPhone(phoneNumber);

        when(staffRepo.findByAddress_Phone_(phoneNumber)).thenReturn(Arrays.asList(staff));

        // Act
        List<Staff> foundStaffList = staffRepo.findByAddress_Phone_(phoneNumber);

        // Assert
        assertNotNull(foundStaffList);
        assertEquals(1, foundStaffList.size());
        assertEquals(phoneNumber, foundStaffList.get(0).getAddress().getPhone());
        verify(staffRepo, times(1)).findByAddress_Phone_(phoneNumber);
    }

    @Test
    void testFindByAddressCity() {
        // Arrange
        String cityName = "New York";
        Staff staff = new Staff();
        staff.setStaffId(1L);
        staff.setAddress(new Address());
        staff.getAddress().setCity(new City());
        staff.getAddress().getCity().setCityName(cityName);

        when(staffRepo.findByAddress_City_CityName(cityName)).thenReturn(Arrays.asList(staff));

        // Act
        List<Staff> foundStaffList = staffRepo.findByAddress_City_CityName(cityName);

        // Assert
        assertNotNull(foundStaffList);
        assertEquals(1, foundStaffList.size());
        assertEquals(cityName, foundStaffList.get(0).getAddress().getCity().getCityName());
        verify(staffRepo, times(1)).findByAddress_City_CityName(cityName);
    }

    @Test
    void testFindByAddressCityCountry() {
        // Arrange
        String countryName = "USA";
        Staff staff = new Staff();
        staff.setStaffId(1L);
        staff.setAddress(new Address());
        staff.getAddress().setCity(new City());
        staff.getAddress().getCity().setCountry(new Country());
        staff.getAddress().getCity().getCountry().setCountry(countryName);

        when(staffRepo.findByAddress_City_Country_Country(countryName)).thenReturn(Arrays.asList(staff));

        // Act
        List<Staff> foundStaffList = staffRepo.findByAddress_City_Country_Country(countryName);

        // Assert
        assertNotNull(foundStaffList);
        assertEquals(1, foundStaffList.size());
        assertEquals(countryName, foundStaffList.get(0).getAddress().getCity().getCountry().getCountry());
        verify(staffRepo, times(1)).findByAddress_City_Country_Country(countryName);
    }

    @Test
    void testFindByUsername() {
        // Arrange
        String username = "john_doe";
        Staff staff = new Staff();
        staff.setStaffId(1L);
        staff.setUsername(username);

        when(staffRepo.findByUsername(username)).thenReturn(staff);

        // Act
        Staff foundStaff = staffRepo.findByUsername(username);

        // Assert
        assertNotNull(foundStaff);
        assertEquals(username, foundStaff.getUsername());
        verify(staffRepo, times(1)).findByUsername(username);
    }

    @Test
    void testSaveStaff() {
        // Arrange
        Staff staff = new Staff();
        staff.setStaffId(1L);
        staff.setFirstName("John");

        when(staffRepo.save(staff)).thenReturn(staff);

        // Act
        Staff savedStaff = staffRepo.save(staff);

        // Assert
        assertNotNull(savedStaff);
        assertEquals(1L, savedStaff.getStaffId());
        assertEquals("John", savedStaff.getFirstName());
        verify(staffRepo, times(1)).save(staff);
    }

    @Test
    void testFindById() {
        // Arrange
        Long staffId = 1L;
        Staff staff = new Staff();
        staff.setStaffId(staffId);
        staff.setFirstName("John");

        when(staffRepo.findById(staffId)).thenReturn(Optional.of(staff));

        // Act
        Optional<Staff> foundStaff = staffRepo.findById(staffId);

        // Assert
        assertTrue(foundStaff.isPresent());
        assertEquals(staffId, foundStaff.get().getStaffId());
        assertEquals("John", foundStaff.get().getFirstName());
        verify(staffRepo, times(1)).findById(staffId);
    }

    @Test
    void testDeleteStaff() {
        // Arrange
        Staff staff = new Staff();
        staff.setStaffId(1L);
        staff.setFirstName("John");

        // Act
        staffRepo.delete(staff);

        // Assert
        verify(staffRepo, times(1)).delete(staff);
    }
}
