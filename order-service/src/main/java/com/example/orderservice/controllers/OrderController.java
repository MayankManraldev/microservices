package com.example.orderservice.controllers;

import com.example.orderservice.configuration.ApplicationConfigListener;
import com.example.orderservice.configuration.circuitbreaker.Resilience4JConfiguration;
import com.example.orderservice.feign.PaymentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JCircuitBreakerFactory;
import org.springframework.cloud.client.circuitbreaker.CircuitBreaker;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orderService")
public class OrderController {
	Logger logger = LoggerFactory.getLogger(OrderController.class);
	@Autowired
	PaymentService paymentService;

	@Autowired
	Resilience4JCircuitBreakerFactory globalCustomConfiguration;

	@GetMapping("/testOrderService")
	public ResponseEntity<String> helloWorld() {

		return new ResponseEntity<>("Hello world from oder service!", HttpStatus.OK);
	}

	@GetMapping("/testOrderFeign")
	public ResponseEntity<String> testOrderFeign() {
		logger.info("starts executing testOrderFeign");
		CircuitBreaker testOrderFeign = globalCustomConfiguration.create("testOrderFeign");
		ResponseEntity<String> responseEntity = testOrderFeign.run(() -> paymentService.testPaymentService(), throwable -> fallBackMethod(throwable));
		return responseEntity;

	}

	private ResponseEntity<String> fallBackMethod(Throwable throwable) {
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.body("Service Unavailable");
	}

}