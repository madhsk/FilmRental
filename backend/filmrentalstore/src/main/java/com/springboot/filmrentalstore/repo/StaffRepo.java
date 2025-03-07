package com.springboot.filmrentalstore.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.springboot.filmrentalstore.model.*;

@Repository
public interface StaffRepo extends JpaRepository<Staff, Long> {
	List<Staff> findByLastName(String lastName);

	List<Staff> findByEmail(String email);

	List<Staff> findByFirstName(String firstName);

	List<Staff> findByAddress_Phone_(String phoneNumber);

	List<Staff> findByAddress_City_CityName(String city);

	List<Staff> findByAddress_City_Country_Country(String country);

	Staff findByUsername(String username);
}
