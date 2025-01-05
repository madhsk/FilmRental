package com.springboot.filmrentalstore.controller;

import com.springboot.filmrentalstore.DTO.*;
import com.springboot.filmrentalstore.exception.*;
import com.springboot.filmrentalstore.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.*;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {

	@Autowired
	private PaymentService paymentService;

	@PostMapping("/add")
	public ResponseEntity<String> addPayment(@RequestBody PaymentDTO paymentDTO) {
	    try {
	        if (paymentDTO.getAmount() <= 0) {
	            throw new InvalidInputException("Payment amount must be greater than zero.");
	        }
	        paymentService.addPayment(paymentDTO);
	        return ResponseEntity.ok("Record Created Successfully");
	    } catch (InvalidInputException e) {
	        return ResponseEntity.badRequest().body("Invalid input: " + e.getMessage());
	    } catch (Exception e) {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred: " + e.getMessage());
	    }
	}
	
	@PostMapping("/create-order")
    public ResponseEntity<?> createOrder(@RequestBody Map<String, Object> paymentData) {
        try {
            double amount = Double.parseDouble(paymentData.get("amount").toString());
            String currency = "INR";
            String receipt = "order_rcptid_11";

            Map<String, Object> orderDetails = paymentService.createOrder(amount, currency, receipt);
            return ResponseEntity.ok(orderDetails);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error creating order: " + e.getMessage());
        }
    }

    @PostMapping("/verify")
    public ResponseEntity<Map<String, String>> verifyPayment(@RequestBody Map<String, String> paymentDetails) {
        Map<String, String> response = new HashMap<>();
        try {
            String razorpayOrderId = paymentDetails.get("razorpay_order_id");
            String razorpayPaymentId = paymentDetails.get("razorpay_payment_id");
            String razorpaySignature = paymentDetails.get("razorpay_signature");

            String payload = razorpayOrderId + "|" + razorpayPaymentId;

            boolean isValid = paymentService.verifySignature(payload, razorpaySignature);
            if (isValid) {
                response.put("message", "Payment verified successfully.");
                response.put("status", "success");
                return ResponseEntity.ok(response);
            } else {
                response.put("message", "Invalid payment signature.");
                response.put("status", "failure");
                return ResponseEntity.status(400).body(response);
            }
        } catch (Exception e) {
            response.put("message", "Payment verification failed: " + e.getMessage());
            response.put("status", "error");
            return ResponseEntity.status(500).body(response);
        }
    }


	@GetMapping("/revenue/datewise")
	public ResponseEntity<Map<LocalDate, Double>> getRevenueDatewise() {
		Map<LocalDate, Double> revenue = paymentService.getCumulativeRevenueDatewise();
		return ResponseEntity.ok(revenue);
	}

	@GetMapping("/revenue/datewise/store/{id}")
	public ResponseEntity<Map<LocalDate, Double>> getRevenueByStoreDatewise(@PathVariable Long id)
			throws ResourceNotFoundException {
		Map<LocalDate, Double> revenue = paymentService.getCumulativeRevenueByStoreDatewise(id);
		if (revenue.isEmpty()) {
			throw new ResourceNotFoundException("No revenue found for the store ID: " + id);
		}
		return ResponseEntity.ok(revenue);
	}

	@GetMapping("/revenue/filmwise")
	public ResponseEntity<Map<String, Double>> getRevenueFilmwise() {
		Map<String, Double> revenue = paymentService.getCumulativeRevenueFilmwise();
		return ResponseEntity.ok(revenue);
	}

	@GetMapping("/revenue/film/{id}")
	public ResponseEntity<Map<String, Double>> getRevenueByFilmStorewise(@PathVariable Long id)
			throws ResourceNotFoundException {
		Map<String, Double> revenue = paymentService.getCumulativeRevenueByFilmStorewise(id);
		if (revenue.isEmpty()) {
			throw new ResourceNotFoundException("No revenue found for the film ID: " + id);
		}
		return ResponseEntity.ok(revenue);
	}

	@GetMapping("/revenue/films/store/{id}")
	public ResponseEntity<Map<String, Double>> getRevenueFilmsByStore(@PathVariable Long id)
			throws ResourceNotFoundException {
		Map<String, Double> revenue = paymentService.getCumulativeRevenueFilmsByStore(id);
		if (revenue.isEmpty()) {
			throw new ResourceNotFoundException("No revenue found for the store ID: " + id);
		}
		return ResponseEntity.ok(revenue);
	}

	@ExceptionHandler(InvalidInputException.class)
	public ResponseEntity<String> handleInvalidInputException(InvalidInputException ex) {
		return new ResponseEntity<>("Invalid input: " + ex.getMessage(), HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<String> handleResourceNotFoundException(ResourceNotFoundException ex) {
		return new ResponseEntity<>("Error: " + ex.getMessage(), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleGenericException(Exception ex) {
		return new ResponseEntity<>("An unexpected error occurred: " + ex.getMessage(),
				HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
