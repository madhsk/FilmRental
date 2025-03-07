package com.springboot.filmrentalstore.controller;

import com.springboot.filmrentalstore.model.*;
import com.springboot.filmrentalstore.DTO.*;
import com.springboot.filmrentalstore.exception.*;
import com.springboot.filmrentalstore.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stores")
public class StoreController {

    @Autowired
    StoreService storeService;

    @GetMapping("/all")
    public List<Store> getAllStores() {
        return storeService.getAllStores();
    }

    // Add New Store
    @PostMapping("/add")
    public ResponseEntity<?> addStore(@RequestBody StoreDTO storeDTO)
            throws ResourceNotFoundException {
    	try {
            // Assuming you have a service method to save the store
            storeService.addStore(storeDTO);
            return new ResponseEntity<>("Store Created", HttpStatus.CREATED);
        } catch (Exception e) {
        	e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to add store: " + e.getMessage());
        }
        
    }

    // Assign address to store
    @PutMapping("/{storeId}/address/{addressId}")
    public ResponseEntity<StoreDTO> assignAddressToStore(@PathVariable Long storeId, @PathVariable Long addressId)
            throws ResourceNotFoundException {
        StoreDTO updatedStore = storeService.assignAddressToStore(storeId, addressId);
        return ResponseEntity.ok(updatedStore);
    }

    // Get Store By City
    @GetMapping("/city/{city}")
    public List<StoreDTO> getStoresByCity(@PathVariable String city) throws ResourceNotFoundException {
        return storeService.getStoresByCity(city);
    }

    // Get Store By Country
    @GetMapping("/country/{country}")
    public List<StoreDTO> getStoresByCountry(@PathVariable String country) throws ResourceNotFoundException {
        return storeService.getStoreIdsByCountry(country);
    }

    // Get Store By Phone Number
    @GetMapping("/phone/{phone}")
    public ResponseEntity<StoreDTO> getStoreByPhone(@PathVariable String phone) throws ResourceNotFoundException {
        StoreDTO store = storeService.getStoreByPhone(phone);
        return ResponseEntity.ok(store);
    }

    // Update Store Phone Number
    @PutMapping("/update/{storeId}/{phone}")
    public ResponseEntity<?> updateStorePhoneNumber(@PathVariable Long storeId, @PathVariable String phone)
            throws InvalidInputException {
        try {
            String message = storeService.updatePhoneNumber(storeId, phone);
            System.out.println("Returning message: " + message);  // Log the response for debugging
            return ResponseEntity.ok(message);
        } catch (ResourceNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
    }

    // Get Staff By Store ID
    @GetMapping("/staff/{storeId}")
    public List<Staff> getStaffByStoreId(@PathVariable long storeId) throws ResourceNotFoundException {
        return storeService.getStaffByStoreId(storeId);
    }

    // Get Customers By Store ID
    @GetMapping("/customer/{storeId}")
    public ResponseEntity<List<CustomerStoreDTO>> getCustomersByStore(@PathVariable Long storeId)
            throws ResourceNotFoundException {
        List<CustomerStoreDTO> customers = storeService.getCustomersByStoreId(storeId);
        return ResponseEntity.ok(customers);
    }

    // Get Manager By Store ID
    @GetMapping("/manager/{storeId}")
    public ResponseEntity<ManagerDetailsDTO> getManagerDetailsByStoreId(@PathVariable Long storeId)
            throws ResourceNotFoundException {
        ManagerDetailsDTO managerDetails = storeService.getManagerDetailsByStoreId(storeId);
        return ResponseEntity.ok(managerDetails);
    }

    // Get All Managers and Store Details
    @GetMapping("/managers")
    public ResponseEntity<List<ManagerDetailsDTO>> getAllManagerAndStoreDetails() {
        List<ManagerDetailsDTO> managerAndStoreDetails = storeService.getAllManagerAndStoreDetails();
        if (managerAndStoreDetails != null) {
            for (ManagerDetailsDTO dto : managerAndStoreDetails) {
                if (dto.getStaffId() == null) {
                    dto.setFirstName("No manager assigned");
                }
            }
        }
        return ResponseEntity.ok(managerAndStoreDetails);
    }

    // Assign Manager To Store
    @PutMapping("/{storeId}/manager/{managerStaffId}")
    public ResponseEntity<StoreDTO> assignManagerToStore(@PathVariable Long storeId, @PathVariable Long managerStaffId)
            throws ResourceNotFoundException {
        StoreDTO updatedStore = storeService.assignManagerToStore(storeId, managerStaffId);
        return ResponseEntity.ok(updatedStore);
    }
}
