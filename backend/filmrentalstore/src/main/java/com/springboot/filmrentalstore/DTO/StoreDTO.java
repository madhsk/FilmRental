package com.springboot.filmrentalstore.DTO;

import java.time.LocalDateTime;
import java.util.List;
import com.springboot.filmrentalstore.model.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

public class StoreDTO {

	@NotNull(message = "Store ID Is Required")
	private Long storeId;

	@NotNull(message = "Address Is Required")
	@Valid
	private Address address;
	
	@NotNull(message = "Manager Is Required")
	@Valid
	private Staff manager;

	@NotNull(message = "Last Update Time Is Required")
	@PastOrPresent(message = "Last update must be in the past or present")
	private LocalDateTime lastUpdate;

	@Valid
	private List<Customer> customers;

	@Valid
	private List<Staff> staff_list;

	public Long getStoreId() {
		return storeId;
	}

	public void setStoreId(Long storeId) {
		this.storeId = storeId;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Staff getManager() {
		return manager;
	}

	public void setManager(Staff manager) {
		this.manager = manager;
	}

	public LocalDateTime getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(LocalDateTime lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public List<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

	public List<Staff> getStaff_list() {
		return staff_list;
	}

	public void setStaff_list(List<Staff> staff_list) {
		this.staff_list = staff_list;
	}

	

	
	public StoreDTO() {
		super();
	}

	

	public StoreDTO(Long expectedStoreId, Address expectedAddress,
			LocalDateTime expectedLastUpdate, List<Customer> expectedCustomers, List<Staff> expectedStaffList) {
		this.storeId = expectedStoreId;
		this.address = expectedAddress;
		this.lastUpdate =expectedLastUpdate;
		this.customers =expectedCustomers;
		this.staff_list =expectedStaffList;
		
	}

	public StoreDTO(@NotNull(message = "Store ID Is Required") Long storeId,
			@NotNull(message = "Address Is Required") @Valid Address address,
			@NotNull(message = "Manager Is Required") @Valid Staff manager,
			@NotNull(message = "Last Update Time Is Required") @PastOrPresent(message = "Last update must be in the past or present") LocalDateTime lastUpdate,
			@Valid List<Customer> customers, @Valid List<Staff> staff_list) {
		super();
		this.storeId = storeId;
		this.address = address;
		this.manager = manager;
		this.lastUpdate = lastUpdate;
		this.customers = customers;
		this.staff_list = staff_list;
	}

	

	
	
	
}