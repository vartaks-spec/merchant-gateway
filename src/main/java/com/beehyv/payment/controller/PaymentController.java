package com.beehyv.payment.controller;

import com.beehyv.payment.dto.PaymentRequest;
import com.beehyv.payment.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/request")
    public ResponseEntity<String> requestPayment(@RequestBody PaymentRequest request) {

        return paymentService.makePayment(request);
    }

    @GetMapping("/status/{paymentCode}")
    public ResponseEntity<String> checkPaymentStatus(@PathVariable String paymentCode) {
        // Logic to get from database
        return paymentService.checkPayment(paymentCode);
    }
}

