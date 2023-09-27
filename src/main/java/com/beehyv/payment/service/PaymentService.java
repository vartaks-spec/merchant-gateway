package com.beehyv.payment.service;

import com.beehyv.payment.dto.PaymentRequest;
import org.springframework.http.ResponseEntity;

public interface PaymentService {
    ResponseEntity<String> makePayment(PaymentRequest request);
    ResponseEntity<String> checkPayment(String paymentId);


}
