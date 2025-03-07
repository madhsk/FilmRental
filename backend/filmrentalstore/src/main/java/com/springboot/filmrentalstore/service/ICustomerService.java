package com.springboot.filmrentalstore.service;

import java.util.List;

import com.springboot.filmrentalstore.DTO.CustomerDTO;
import com.springboot.filmrentalstore.exception.ResourceNotFoundException;
import com.springboot.filmrentalstore.model.Address;
import com.springboot.filmrentalstore.model.Store;

public interface ICustomerService {
	CustomerDTO assignStoreToCustomer(Long customerId, Store store) throws ResourceNotFoundException;

	CustomerDTO updateCustomerPhone(Long customerId, String phone) throws ResourceNotFoundException;

	CustomerDTO updateEmail(Long id, String email) throws ResourceNotFoundException;

	List<CustomerDTO> getCustomersByPhone(String phone) throws ResourceNotFoundException;

	CustomerDTO updateLastName(Long id, String lastName) throws ResourceNotFoundException;

	CustomerDTO updateFirstName(Long id, String firstName) throws ResourceNotFoundException;

	List<CustomerDTO> getInactiveCustomers();

	List<CustomerDTO> getActiveCustomers();

	List<CustomerDTO> getCustomersByCountryName(String countryName) throws ResourceNotFoundException;

	List<CustomerDTO> getCustomersByCityName(String cityName) throws ResourceNotFoundException;

	List<CustomerDTO> getCustomersByEmail(String email) throws ResourceNotFoundException;

	List<CustomerDTO> getCustomersByFirstName(String firstName) throws ResourceNotFoundException;

	List<CustomerDTO> getCustomersByLastName(String lastName) throws ResourceNotFoundException;

	CustomerDTO assignNewAddressToCustomer(Long customerId, Address address) throws ResourceNotFoundException;

	CustomerDTO assignAddressToCustomer(Long customerId, Long addressId) throws ResourceNotFoundException;

	CustomerDTO updateCustomer(Long id, CustomerDTO customerDTO) throws ResourceNotFoundException;

	CustomerDTO createCustomer(CustomerDTO customerDTO);

	List<CustomerDTO> getAllCustomers();

	List<CustomerDTO> findByStore_StoreId(long storeId) throws ResourceNotFoundException;

	CustomerDTO getCustomerById(Long id) throws ResourceNotFoundException;
}
