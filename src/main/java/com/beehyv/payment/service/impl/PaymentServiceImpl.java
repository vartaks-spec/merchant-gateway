package com.beehyv.payment.service.impl;

import com.beehyv.payment.dto.PaymentRequest;
import com.beehyv.payment.entity.Payment;
import com.beehyv.payment.repository.PaymentRepository;
import com.beehyv.payment.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;
    @Override
    public ResponseEntity<String> makePayment(PaymentRequest request) {
        String paymentCode = generatePaymentCode();
        Payment payment = new Payment(null, request.getMerchantId(), request.getAmount(), request.getCurrency(), request.getOrderId(), "True", paymentCode);
        paymentRepository.save(payment);
        return ResponseEntity.ok("Payment Done successfully with payment code as: " + paymentCode );
    }

    private String generatePaymentCode() {
        return UUID.randomUUID().toString();
    }

    @Override
    public ResponseEntity<String> checkPayment(String paymentId) {
           Optional <Payment> payment = paymentRepository.findByPaymentCode(paymentId);
           if(payment.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
           else if (payment.get().getPaymentStatus().equals("True"))
               return ResponseEntity.ok("Payment Was Successful");
           else
               return  ResponseEntity.ok("Payment Was UnSuccessful");
    }
}
