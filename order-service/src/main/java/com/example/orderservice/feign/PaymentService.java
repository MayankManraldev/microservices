package com.example.orderservice.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "payment-service")
public interface PaymentService {

    @GetMapping("/paymentService/testPaymentService")
    public ResponseEntity<String> testPaymentService();
}
