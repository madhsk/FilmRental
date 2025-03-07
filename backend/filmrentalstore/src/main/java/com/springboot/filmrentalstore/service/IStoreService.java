package com.springboot.filmrentalstore.service;

import java.util.List;

import com.springboot.filmrentalstore.DTO.*;
import com.springboot.filmrentalstore.exception.ResourceNotFoundException;
import com.springboot.filmrentalstore.model.*;

public interface IStoreService {

	// Get All Store
	List<Store> getAllStores();

	// Add New Store
	public Store addStore(StoreDTO storeDTO) throws ResourceNotFoundException;

	// Assign Address To Store
	StoreDTO assignAddressToStore(Long storeId, Long addressId) throws ResourceNotFoundException;

	// Retrieve stores by city
	List<StoreDTO> getStoresByCity(String cityName) throws ResourceNotFoundException;

	// Get store by Country
	List<StoreDTO> getStoreIdsByCountry(String country) throws ResourceNotFoundException;

	// Retrieve store by phone number
	StoreDTO getStoreByPhone(String phone) throws ResourceNotFoundException;

	// Update phone number of a store
	String updatePhoneNumber(Long storeId, String phone) throws ResourceNotFoundException;

	// Get all staff information by store ID
	List<Staff> getStaffByStoreId(Long storeId) throws ResourceNotFoundException;

	// Get all customers Information By Store Id
	List<CustomerStoreDTO> getCustomersByStoreId(Long storeId) throws ResourceNotFoundException;

	List<ManagerDetailsDTO> getAllManagerAndStoreDetails();

	StoreDTO assignManagerToStore(Long storeId, Long managerStaffId) throws ResourceNotFoundException;

	ManagerDetailsDTO getManagerDetailsByStoreId(Long storeId) throws ResourceNotFoundException;
}
