package com.springboot.filmrentalstore.service;

import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.Utils;
import com.springboot.filmrentalstore.DTO.PaymentDTO;
import com.springboot.filmrentalstore.exception.InvalidInputException;
import com.springboot.filmrentalstore.model.*;
import com.springboot.filmrentalstore.repo.*;

import org.json.JSONObject;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

@Service
public class PaymentService implements IPaymentService {
	@Autowired 
	PaymentRepo paymentRepo;

	@Autowired
	ModelMapper modelMapper;
	@Value("${razorpay.key_Id}")
    private String keyId;

    @Value("${razorpay.key_secret}")
    private String keySecret;

    
    public Map<String, Object> createOrder(double amount, String currency, String receipt) throws Exception {
        RazorpayClient razorpayClient = new RazorpayClient(keyId, keySecret);
        Map<String, Object> options = new HashMap<>();
        options.put("amount", (int) (amount * 100)); 
        options.put("currency", currency);
        options.put("receipt", receipt);
        JSONObject orderRequest = new JSONObject(options);  
        Order order = razorpayClient.orders.create(orderRequest);
        Map<String, Object> response = new HashMap<>();
        response.put("id", order.get("id"));
        response.put("amount", order.get("amount"));
        response.put("currency", order.get("currency"));
        response.put("status", order.get("status"));
        return response;
    }

    
    public boolean verifySignature(String payload, String razorpaySignature) throws Exception {
       
        return Utils.verifySignature(payload, razorpaySignature, keySecret);
    }
	@Override
	public void addPayment(PaymentDTO paymentDTO) throws InvalidInputException {
        if (paymentDTO.getAmount() <= 0) {
            throw new InvalidInputException("Amount must be greater than zero.");
        }
        Payment payment = new Payment();
        payment.setPaymentId(paymentDTO.getPaymentId());
        payment.setPaymentDate(paymentDTO.getPaymentDate());
        payment.setAmount(paymentDTO.getAmount());
        payment.setLastUpdate(paymentDTO.getLastUpdate());
        payment.setCustomer(modelMapper.map(paymentDTO.getCustomer(),Customer.class));
        payment.setStaff(modelMapper.map(paymentDTO.getStaff(),Staff.class));
        payment.setRental(modelMapper.map(paymentDTO.getRental(),Rental.class));
        paymentRepo.save(payment);
    }



	@Override
	public Map<LocalDate, Double> getCumulativeRevenueDatewise() {
		List<Payment> payments = paymentRepo.findAll();
		Map<LocalDate, Double> revenueMap = new HashMap<>();

		for (Payment payment : payments) {
			LocalDate paymentDate = payment.getPaymentDate().toLocalDate();
			revenueMap.put(paymentDate, revenueMap.getOrDefault(paymentDate, 0.0) + payment.getAmount());
		}

		return revenueMap;
	}

	@Override
	public Map<LocalDate, Double> getCumulativeRevenueByStoreDatewise(Long storeId) {
		List<Payment> payments = paymentRepo.findAll();
		Map<LocalDate, Double> revenueMap = new HashMap<>();

		for (Payment payment : payments) {
			if (payment.getRental().getInventory().getStore().getStoreId().equals(storeId)) {
				LocalDate paymentDate = payment.getPaymentDate().toLocalDate();
				revenueMap.put(paymentDate, revenueMap.getOrDefault(paymentDate, 0.0) + payment.getAmount());
			}
		}
		return revenueMap;
	}

	@Override
	public Map<String, Double> getCumulativeRevenueFilmwise() {
		List<Payment> payments = paymentRepo.findAll();
		Map<String, Double> filmRevenueMap = new HashMap<>();

		for (Payment payment : payments) {
			String filmTitle = payment.getRental().getInventory().getFilm().getTitle();
			filmRevenueMap.put(filmTitle, filmRevenueMap.getOrDefault(filmTitle, 0.0) + payment.getAmount());
		}

		return filmRevenueMap;
	}

	@Override
	public Map<String, Double> getCumulativeRevenueByFilmStorewise(Long filmId) {
		List<Payment> payments = paymentRepo.findAll();
		Map<String, Double> filmStoreRevenueMap = new HashMap<>();

		for (Payment payment : payments) {
			if (payment.getRental().getInventory().getFilm().getFilmId().equals(filmId)) {
				String filmName = payment.getRental().getInventory().getFilm().getTitle(); // Get film name
				String storeAddress = payment.getRental().getInventory().getStore().getAddress().getAddress(); // Get
																												// store
																												// address

				String key = filmName + " - " + storeAddress; // Create a composite key
				filmStoreRevenueMap.put(key, filmStoreRevenueMap.getOrDefault(key, 0.0) + payment.getAmount());
			}
		}

		return filmStoreRevenueMap;
	}

	@Override
	public Map<String, Double> getCumulativeRevenueFilmsByStore(Long storeId) {
		List<Payment> payments = paymentRepo.findAll();
		Map<String, Double> filmRevenueMap = new HashMap<>();

		for (Payment payment : payments) {
			if (payment.getRental().getInventory().getStore().getStoreId().equals(storeId)) {
				String filmTitle = payment.getRental().getInventory().getFilm().getTitle();
				filmRevenueMap.put(filmTitle, filmRevenueMap.getOrDefault(filmTitle, 0.0) + payment.getAmount());
			}
		}

		return filmRevenueMap;
	}

}
