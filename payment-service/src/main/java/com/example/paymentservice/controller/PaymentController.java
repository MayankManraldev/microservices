package com.example.paymentservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("paymentService")
public class PaymentController {
	Logger logger = LoggerFactory.getLogger(PaymentController.class);
	@GetMapping("/testPayment")
	public ResponseEntity<String> testPayment() {
		String test="Testing Payment Service from Order Service";
		return new ResponseEntity<>(test,HttpStatus.OK);
	}

	@GetMapping("/testPaymentService")
	public ResponseEntity<String> testPaymentService() {
		logger.info("start executing testPaymentService");
		String test="Testing Payment Service from Order Service";
		return new ResponseEntity<>(test,HttpStatus.OK);
	}

}